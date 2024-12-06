function loadHallgatok() {
    fetch('/api/hallgatok')
        .then(response => response.json())
        .then(data => {
            document.getElementById('output').innerHTML = JSON.stringify(data, null, 2);
        });
}

function loadKurzusok() {
    fetch('/api/kurzusok')
        .then(response => response.json())
        .then(data => {
            document.getElementById('output').innerHTML = JSON.stringify(data, null, 2);
        });
}

function addHallgato() {
    const nev = prompt("Adja meg a hallgató nevét:");
    const neptunKod = prompt("Adja meg a Neptun kódot:");
    fetch('/api/hallgatok', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nev, neptunKod }),
    }).then(response => {
        if (response.ok) {
            alert("Hallgató hozzáadva!");
        }
    });
}
