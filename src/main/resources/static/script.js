$(document).ready(function () {
    $.get("http://localhost:8088/wallOfFame", function (data) {
        $('.wallOfFame-id').append(data.id);
        var nom = document.querySelector('.wallOfFame-nom');
        var note = document.querySelector('.wallOfFame-note');
        var n = "";
        var m = "";
        data.forEach(function (user) {
            n = n + "<br>" + user.pseudo;
            m = m + "<br>" + user.moyenne;
        });
        nom.innerHTML = n;
        note.innerHTML = m;

    });
});