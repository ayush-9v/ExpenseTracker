document.addEventListener("DOMContentLoaded", function() {
    const i = document.getElementById("total-income");
    const e = document.getElementById("total-expense");
    const be = document.getElementById("balance");

    if (i && e && be) {
        const income = parseFloat(i.innerText) || 0;
        const expense = parseFloat(e.innerText) || 0;
        
        const balance = income - expense;
        be.innerText = balance.toFixed(2);

        if (balance < 10000) {
            be.style.color = "red";
        } else {
            be.style.color = "green";
        }
    }
});