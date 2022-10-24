let isYValid = false;

const yValue = document.getElementById("y-value");

yValue.addEventListener("keyup", function () {
    isYValid = yValue.value <= 5 && yValue.value >= -5 && !isNaN(yValue.value) && (yValue.value.length !== 0);
    isFormReadyToSent();
})


/**
 * Проверить, что форма готова к отправке
 * */
function isFormReadyToSent() {
    const form = document.getElementById("main-form");
    const formData = new FormData(form);

    if (!formData.has('x') || !isYValid || !formData.has('r')) {
        setSubmitButtonDisabled();
        return;
    }

    setSubmitButtonEnabled();
}


/**
 * Установить кнопку отправки формы в НЕактивное состояние
 * */
function setSubmitButtonDisabled(){
    document.getElementById("check-button").disabled = true;
}


/**
 * Установить кнопку отправки формы в АКТИВНОЕ состояние
 * */
function setSubmitButtonEnabled(){
    document.getElementById("check-button").disabled = false;
}