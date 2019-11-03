
const menu = {
    id: 101,
    name: "Menu de pizza, bebida y tacos",
    description: "Soy un menu mejor que el de macdonalds",
    categories: ["pizza", "beverages", "tacos"],
    reputation: 3,
    price: 270,
    offers: [
        {price: 250, minAmount: 15},
        {price: 190, minAmount: 30},
    ],
    minAmountIn10Days: 0,
    service: {
        logo: "https://images.freshop.com/1898840097940308805/abb47d1a38cb534368bd6362da5c5dd4_medium.png",
        name: "Viandas Las Eugenias",
        reputation: 3,
        location: {
            address: "Alsina 233",
            city: "Quilmes",
            "latitude": 41.88432,
            "longitude": -87.6387699
        }
    }
};

export default menu;