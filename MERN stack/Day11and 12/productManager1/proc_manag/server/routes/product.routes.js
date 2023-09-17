const productController = require('../controllers/product.controller')


module.exports = app => {

    app.get('/api/product' , productController.findAllProduct);
    app.get('/api/product/:id',productController.findOneProduct);
    app.post('/api/product',productController.createProduct);
    app.put('/api/product/:id',productController.updateProduct);
    app.delete('/api/product/:id',productController.deleteProduct)

}