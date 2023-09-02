const { defineConfig } = require('@vue/cli-service')

module.exports = {
  outputDir: "../src/main/resources/static",
  devServer: {
    port: 8081,
    proxy: {
      '/login': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
}


