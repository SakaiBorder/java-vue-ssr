package com.example.ssr.renderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

@Component
public class ServerSideRenderer {

    public String render(String route) throws ScriptException, IOException {

        ScriptEngine engine = getEngine();
        ScriptContext context = getContext();
        Bindings engineScope = engineSetting(engine, context);

        engineScope.put("route", route);
        engine.eval(read("static/js/server.js"), context);
        
		return context.getAttribute("rendered").toString();
	}

    private ScriptEngine getEngine() {
        return new ScriptEngineManager().getEngineByName("graal.js");
    }

    private ScriptContext getContext() {
        return new SimpleScriptContext();
    }

    private Bindings engineSetting(ScriptEngine engine, ScriptContext context) throws ScriptException, IOException {
        context.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
        Bindings engineScope = context.getBindings(ScriptContext.ENGINE_SCOPE);
        engineScope.put("rendered", null);
        engine.setContext(context);

        engine.eval(
                "var process = { env: { VUE_ENV: 'server', NODE_ENV: 'production' }}; this.global = { process: process };",
                context);
        loadFiles(engine, context);

        return engineScope;
    }

    private void loadFiles(ScriptEngine engine, ScriptContext context) throws IOException, ScriptException {

        String root = System.getProperty("user.dir");
        String vueRenderer = "/node_modules/vue-server-renderer/";
        Path path = Path.of(root + vueRenderer);
        Path file = path.resolve("basic.js");

        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            InputStream in = resource.getInputStream();
            String all = all(new BufferedReader(new InputStreamReader(in)));
            engine.eval(all, context);
        }
    }

    private String all(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String string;

        string = reader.readLine();
        while (string != null){
            builder.append(string + System.getProperty("line.separator"));
            string = reader.readLine();
        }
        return builder.toString();
    }
    
    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }
}
