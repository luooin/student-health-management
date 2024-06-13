module.exports = {
    filenameHashing : false,
    // webpack配置
    devServer: {
        open: true,
        host: "localhost",
        port: 80,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws:true,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/api'
                }
            }
        }
    },
}
