$(document).ready(function () {
    $.get("http://localhost:8088/wallOfFame", function (data) {
        let i = 0;
        data.forEach(function (user) {
            i++;
            console.log(user.pseudo);
            insertionTableau(user.moyenne, user.pseudo, i);
        });

    });
});

function insertionTableau(nom, note, i) {
    const table = document.querySelector('.tableau');
    let tr = document.createElement('tr');
    table.appendChild(tr);

    let td = document.createElement('td');
    tr.appendChild(td);
    td.innerHTML = i;

    let td2 = document.createElement('td');
    tr.appendChild(td2);
    td2.innerHTML = note;
    let td1 = document.createElement('td');
    tr.appendChild(td1);
    td1.innerHTML = nom;
}

