const mongoose = require('mongoose');
const ProductSchema = new mongoose.Schema({


    title: {
        type:String,
        required:[true, "product name is required"],
        minLength:[3,"product name must be greater than 3 characters"]
    
    },
    description: {
        type:String,
        required:[true, "description is required"],
        minLength:[10,"product description must be greater than 10 characters"]
    
    },
    price:{
        type: Number,
        required : [true,"{PATH}"]

    },

},{timestamps:true})
const Product = mongoose.model('Product',ProductSchema);
module.exports = Product;