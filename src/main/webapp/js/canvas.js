const canvas = document.querySelector('canvas');
const context = canvas.getContext("2d");
const width = canvas.width;
const height = canvas.height;
const scaleR = canvas.width / 3;
const arrowDeltaInPx = 8;

canvas.addEventListener('mousedown', function(e) {
    getCursorPosition(canvas, e)
});

/**
 * Функция для обработки клика на canvas
 * */
function getCursorPosition(canvas, event) {

    const form = document.getElementById("main-form");
    const formData = new FormData(form);

    if (!formData.has('r')) {
        alert("Для начала выберите R!");
        return;
    }

    console.log(" x: " + event.offsetX + " y: " + event.offsetY)
    const r = formData.get("r");

    const x = convertFromClickToX(event.offsetX, r);
    const y = convertFromClickToY(event.offsetY, r);
    form["x"].value = x;
    form["y"].value = y;

    form.submit();
}


context.fillStyle = "#4CAF50";

// Треугольник
context.beginPath();
context.moveTo(width / 2, height / 2);
context.lineTo((width / 2) / 3 * 5, height / 2);
context.lineTo(width / 2, (height / 2) - (((width / 2) / 3) * 2));
context.fill();

// Круг
context.beginPath();
context.arc(width / 2, height / 2, height / 6, Math.PI / 2, - Math.PI, false);
context.lineTo(width / 2, height / 2)
context.fill();

// Прямоугольник
context.beginPath();
context.rect(width / 2, height / 2, width / 3, height / 3);
context.fill();

drawArrowOnCanvas(0, height / 2, width, height / 2);
context.beginPath();
context.moveTo(width, height / 2);
context.lineTo(width - arrowDeltaInPx, (height / 2) - arrowDeltaInPx);
context.lineTo(width - arrowDeltaInPx, (height / 2) + arrowDeltaInPx);
context.fill();

drawArrowOnCanvas(width / 2, height, width / 2, 0);
context.beginPath();
context.moveTo(width / 2, 0);
context.lineTo((width / 2) - arrowDeltaInPx, arrowDeltaInPx);
context.lineTo((width / 2) + arrowDeltaInPx, arrowDeltaInPx);
context.fill();

context.font = "lighter 13px fantasy";

// x -R
context.beginPath();
context.moveTo(width / 6, (height / 2) - 5);
context.lineTo(width / 6, (height / 2) + 5);
context.stroke();
context.fillText("-R", width / 6, (height / 2) - 5);

// x -R/2
context.beginPath();
context.moveTo(width / 3, (height / 2) - 5);
context.lineTo(width / 3, (height / 2) + 5);
context.stroke();
context.fillText("-R/2", width / 3, (height / 2) - 5);

// x R/2
context.beginPath();
context.moveTo((width / 3) * 2, (height / 2) - 5);
context.lineTo((width / 3) * 2, (height / 2) + 5);
context.stroke();
context.fillText("R/2", (width / 3) * 2, (height / 2) - 5);

// x R
context.beginPath();
context.moveTo((width / 6) * 5, (height / 2) - 5);
context.lineTo((width / 6) * 5, (height / 2) + 5);
context.stroke();
context.fillText("R", (width / 6) * 5, (height / 2) - 5);

// y R
context.beginPath();
context.moveTo((width / 2) - 5, height / 6);
context.lineTo((width / 2) + 5, height / 6);
context.stroke();
context.fillText("R", width / 2 + 10, height / 6);

// y R/2
context.beginPath();
context.moveTo(width / 2 - 5, height / 3);
context.lineTo(width / 2 + 5, height / 3);
context.stroke();
context.fillText("R/2", width / 2 + 10, height / 3);

// y -R/2
context.beginPath();
context.moveTo(width / 2 - 5, (height / 3) * 2);
context.lineTo(width / 2 + 5, (height / 3) * 2);
context.stroke();
context.fillText("-R/2", width / 2 + 10, (height / 3) * 2);

// y -R
context.beginPath();
context.moveTo(width / 2 - 5, (height / 6) * 5);
context.lineTo(width / 2 + 5, (height / 6) * 5);
context.stroke();
context.fillText("-R", width / 2 + 10, (height / 6) * 5);

function drawArrowOnCanvas(fromX, fromY, toX, toY) {
    context.fillStyle = "black";
    context.beginPath();
    context.moveTo(fromX, fromY);
    context.lineTo(toX, toY);
    context.lineWidth = 2;
    context.stroke();
}

/**
 * Функция для конвертации координаты X клика мыши
 * */
function convertFromClickToX(x, r){
    return (x - width / 2) / scaleR * r;
}


/**
 * Функция для конвертации координаты Y клика мыши
 * */
function convertFromClickToY(y, r){
    return (height / 2 - y) / scaleR * r;
}

function convertFromXtoClick(x, r){
    return (x / r * scaleR  + width / 2);
    //    return (x * 2 * scaleR * r + width) / 2;
}

function convertFromYtoClick(y, r){
    return (-y / r * scaleR + height / 2)
    //return (height - y * 2 * scaleR * r) / 2;
}

function drawDot(x, y, r, color){
    let xCoord = convertFromXtoClick(x, r);
    let yCoord = convertFromYtoClick(y, r);

    console.log(xCoord, yCoord);

    context.fillStyle = color;
    context.beginPath();
    context.arc(xCoord, yCoord, 3, 0, 2 * Math.PI, false);
    context.lineTo(xCoord, yCoord)
    context.fill();
}

