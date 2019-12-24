colourTable();

function colourTable() {
    let cells = document.getElementsByClassName("tablecell");
    let rows = document.getElementsByClassName("tablerow");
    for (i=0; i< rows.length; i++) {
        let fourNumbers = new Array();
        for (j=0; j<4; j++) {
            fourNumbers[j] = cells[(4*i)+j].innerHTML;
        }
        fourNumbers.sort();
        console.log(fourNumbers);
        for (k=0; k<4; k++) {
            if (cells[(4 * i) + k].innerHTML == fourNumbers[0]) {
                cells[(4 * i) + k].style.backgroundColor = "#FCD1E2";
            } else if (cells[(4 * i) + k].innerHTML == fourNumbers[1]) {
                cells[(4 * i) + k].style.backgroundColor = "#F3AAC7";
            } else if (cells[(4 * i) + k].innerHTML == fourNumbers[2]) {
                cells[(4 * i) + k].style.backgroundColor = "#E17493";
            } else {
                cells[(4 * i) + k].style.backgroundColor = "#D8344A";
            }
        }
    }

}