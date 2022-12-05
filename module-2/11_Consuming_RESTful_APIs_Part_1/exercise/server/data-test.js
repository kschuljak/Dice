module.exports = () => {
    var faker = require("faker");

    const data = { auctions: [] }

    //hard-code these details so they're the same, use faker for start/end date so it's current when run
    const products = [
        {
            "id": 0,
            "title": "Zero",
            "description": "Zero Auction",
            "user": "User0",
            "currentBid": 0.0
        },
        {
            "id": 1,
            "title": "One",
            "description": "One Auction",
            "user": "User1",
            "currentBid": 1.1
        }
    ];

    for (let i = 0; i < products.length; i++) {
        var newItem = {
            id: i + 1,
            title: products[i].title,
            description: products[i].description,
            user: products[i].user,
            currentBid: products[i].currentBid,
            startDate: faker.date.recent(5),
            endDate: faker.date.recent(-5)
        };
        // console.log(newItem);
        data.auctions.push(newItem);
    }
    return data;
  }
