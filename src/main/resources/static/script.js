$(document).ready(function () {
    $.get("http://localhost:8088/wallOfFame", function (data) {
        //Récupération du wallOfFame et stockage dans data
        let i = 0;
        data.content.forEach(function (user) {
            i++;
            //Création d'une ligne dans le tableau pour chaque valeur du wall of fame
            insertionTableau(user.moyenne, user.pseudo, i);
        });

    });
});

//Fonction permettant de créer une ligne dans le tableau

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

