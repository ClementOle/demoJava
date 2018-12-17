$(document).ready(function () {
    $.get("http://localhost:8088/wallOfFame", function (data) {
        $('.wallOfFame-id').append(data.id);
        var nom = document.querySelector('.wallOfFame-nom');
        var note = document.querySelector('.wallOfFame-note');
        var n = "";
        var m = "";
        let i = 0;
        data.forEach(function (user) {
            n = n + "<br>" + user.pseudo;
            m = m + "<br>" + user.moyenne;
            i++;
            insertionTableau(m, n, i);

        });
        nom.innerHTML = n;
        note.innerHTML = m;

    });
});

function insertionTableau(nom, note, i) {
    const table = document.querySelector('.tableau');
    let tr = document.createElement('tr');
    table.appendChild(tr);

    let td2 = document.createElement('td');
    tr.appendChild(td2);
    td2.innerHTML = note;
    let td1 = document.createElement('td');
    tr.appendChild(td1);
    td1.innerHTML = nom;
    let td = document.createElement('td');
    tr.appendChild(td);
    td.innerHTML = i;


}