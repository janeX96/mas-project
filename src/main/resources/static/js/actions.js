function showAlert() {
    alert("The button was clicked!");
}

function changeProductsList() {

    var selectedOrder = eorder.options[eorder.selectedIndex].value;
    var productsList = document.getElementById("products");

   // alert("Wybrano: " + productsList.options[eorder.selectedIndex].value);

    while (productsList.options.length){
        productsList.remove(0);
    }


    for (let i = 0; i < selectedOrder.length; i++) {
        var prod = new Option(selectedOrder[i],i);
        productsList.options.add(prod);
    }


}