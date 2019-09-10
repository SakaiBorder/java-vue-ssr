package com.example.ssr.service;

import com.example.ssr.renderer.ServerSideRenderer;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RenderService {

    private final ServerSideRenderer renderer;

    public String renderPage(String route) {

        String html = "";
        try {
            html = renderer.render(route);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return html;
    }

}
