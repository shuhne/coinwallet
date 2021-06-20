const app = Vue.createApp({});

app.component("createwallet",{
    template:`
    <div>

    <input v-model="currencyField" placeholder="Currency" ref="currencyinput">
    <input v-model="valueField" placeholder="Value" ref="valueInput" @keyup.enter="save()">
    <button type="button" @click="save()">Save</button>
    </div>
    
    <div>
    <h2>Overview about your wallets</h2>
    <table>
    <thead>
    <tr>
       
        <th>Currency</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <tr v-if="items.length === 0">
        <td colspan="2">You have no wallets yet.</td>
    </tr>
    <tr v-for="coinwallets in items">
    
    <td>{{coinwallet.coincurrency}}</td>
    <td>{{coinwallet.coinvalue}}</td>
    </tr>
    <tr>
    
    <td>{{ currencyField }}</td>
    <td>{{ valueField }}</td>
    </tr>
    </tbody>
    </table>
   </div>
 `,
    data(){
        return {
            items: [],

            currencyField: "",
            valueField: "",
        };
    },
    methods: {
        loadWallets() {
            axios.get("/getcoinwallet")
                .then(response => (this.items = response.data))
        },
        save() {
            axios.post("/savecoinwallet", {

                coincurrency: this.currencyField,
                coinvalue: this.valueField
                 })
                .then((response) => {

                 this.currencyField = "";
                 this.valueField = "";
                 this.$refs.currencyinput.focus();
                 this.loadWallets();
                 }, (error) => {
                console.log("Error: Could not save new wallets")
                });
        }
    },
    mounted: function(){
        this.loadWallets();
    }
});

app.mount("#createwallet");