/*
* Установить только один чекбокс X в активное положение
* */
function setCheckedOnlyOneCheckbox(id) {
    const checkboxPrefix = "checkbox";
    for (let i = 1; i <= 9; i++) {
        if (checkboxPrefix + i !== id) {
            document.getElementById(checkboxPrefix + i).checked = false;
        }
        document.getElementById("x-hidden-value").value = document.getElementById(id).value;
    }
    isFormReadyToSent();
}