const proxy = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(proxy('/api/**', { target: 'http://localhost:8080', changeOrigin: true, secure: false }));
    app.use(proxy('/api/**', { target: 'https://viandasya-backend-grupoc1h.herokuapp.com' }));
};
