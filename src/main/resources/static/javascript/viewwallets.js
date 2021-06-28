const app = Vue.createApp({});

app.component("viewwallet",{
    template:`
    <div  class="mx-auto">
    <h4>Check the latest exchange rates right here</h4>
    <table class="table table-striped">
    <thead>
    <tr>      
        <th scope="col">Currency</th>
        <th scope="col">Value</th>
        <th scope="col">Exchange Value (USD)</th>
    </tr>
    </thead>
    <tbody>
    
    <tr v-if="items.length === 0">
        <td colspan="2">You have no wallets yet.</td>
    </tr>
    <tr v-for="coinwallet in items">
  
    <td>{{coinwallet.coincurrency}}</td>
    <td>{{coinwallet.coinvalue}}</td>
    <td>{{coinwallet.price}}</td
    <td style="vertical-align: middle">
        <button type="button" class="btn btn-info" v-on:click="refreshExchange(coinwallet)"> Refresh Exchange Rate</button>
    </td>
    </tr>
    <tr>
    
    </tr>
    </tbody>
    </table>
   </div>
 `,
    data(){
        return {
            items: [],
            coincurrency1: "",
            coinvalue1: "",
            price: "",

        };
    },
    methods: {
        loadWallets() {
            axios.get("/getcoinwallet")
                .then(response => (this.items = response.data))
        },
        refreshExchange(coinwallet) {
            axios.put("/updateexchange/" + coinwallet.id, {
                id: coinwallet.id,
                coincurrency: coinwallet.coincurrency,
                coinvalue: coinwallet.coinvalue,
            })
                .then((response) => {
                    this.loadWallets();
                }, (error) => {
                    console.log( "couldnt refresh")
                });
        }
    },
    mounted: function(){
        this.loadWallets();
    }
});

app.mount("#viewwallet");
