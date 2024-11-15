// Inefficient loop handling and excessive DOM manipulation

function updateList(items) {
    let list = document.getElementById("itemList");
    list.innerHTML = "";
    for (let i = 0; i < items.length; i++) { //cada que se itera el for se consulta el tamaño de items, podiendolo hacer una sola vez antes del for
      let listItem = document.createElement("li");
      listItem.innerHTML = items[i];
      list.appendChild(listItem); //Cada vez que llamas a appendChild, el navegador tiene que recalcular el diseño de la pagina
    }
  }
  

//codigo optimizado
function updateList(items) {
    let list = document.getElementById("itemList");
    
    // Crear un fragmento de documento para evitar múltiples manipulaciones del DOM
    let fragment = document.createDocumentFragment();
    
    // cambiar el for por un forEach
    items.forEach(item => {
        const listItem = document.createElement("li");
        listItem.textContent = item;
        fragment.appendChild(listItem);
    });

    list.innerHTML = '';  // Solo se debe hacer una vez
    list.appendChild(fragment);
}