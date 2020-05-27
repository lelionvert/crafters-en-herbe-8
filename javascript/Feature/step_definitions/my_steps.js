import {computePrice} from "./compute_price";

const assert = require('assert')

const {Given, When, Then} = require('cucumber');

let order
let result

Given(/^A shopping cart$/, (dataTable) => {
    order = dataTable.hashes()
});

When(/^I compute the cart price$/, () => {
    result = computePrice(order)
});
Then(/^I get (\d+)$/, (expected) => {
    assert.equal(result, expected)
});