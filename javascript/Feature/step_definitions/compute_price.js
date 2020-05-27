module.exports = function computePrice(order) {

    return order.reduce((totalPrice, book) => totalPrice + book.Quantity * 10, 0)

}