var CopyWebpackPlugin = require('copy-webpack-plugin');


module.exports = {
    entry: [
        './index.js'
    ],
    devtool: 'source-map',
    output: {
        path: __dirname + '/../resources/public',
        publicPath: '/',
        filename: 'bundle.js'
    },
    plugins: [
        new CopyWebpackPlugin([
            {from: 'assets/**/*'},
            {from: 'index.html'}
        ])
    ],
    module: {
        loaders: [{
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
                presets: ['react', 'es2015', 'stage-1']
            }
        }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};
