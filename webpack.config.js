const path = require('path')
const VueLoaderPlugin = require('vue-loader/lib/plugin')
const MiniCssExtractPlugin = require('mini-css-extract-plugin')

module.exports = {
    mode: 'development',
    entry: {
        app: path.resolve('src/main/js/src', 'entry-client.js'),
        server: path.resolve('src/main/js/src', 'entry-server.js')
    },
    node: {
        child_process: 'empty',
        fs: 'empty',
        net: 'empty',
        tls: 'empty',
    },
    output: {
        filename: '[name].js',
        path: path.join(__dirname, 'src/main/resources/static/js')
    },
    resolve: {
        alias: {
            vue: 'vue/dist/vue.js'
        },
        extensions: [".ts", ".tsx", ".js", ".json"]
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                options:  {
                    presets: [
                        ['@babel/env',
                            {
                                "targets": {
                                    "ie": 11
                                },
                            }
                        ]
                    ]
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader',

            },
            {
                test: /\.css$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                ],
            },
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        new MiniCssExtractPlugin({
            filename: '../css/app.css'
        }) 
    ],
}
