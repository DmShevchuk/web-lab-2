let isYValid = false;

const yValue = document.getElementById("y-value");

yValue.addEventListener("keyup", function () {
    isYValid = yValue.value <= 5 && yValue.value >= -5 && !isNaN(yValue.value) && (yValue.value.length !== 0);
    isFormReadyToSent();
})


/**
 * Проверка на то, что форма готова к отправке
 * */
function isFormReadyToSent() {
    const form = document.getElementById("main-form");
    const formData = new FormData(form);

    console.log(formData.has('x'));
    console.log(isYValid);
    console.log(formData.has('r'));

    if (!formData.has('x') || !isYValid || !formData.has('r')) {
        setSubmitButtonDisabled();
        return;
    }

    setSubmitButtonEnabled();
}


/**
 * Установка кнопки отправки формы в НЕактивное состояние
 * */
function setSubmitButtonDisabled(){
    document.getElementById("check-button").disabled = true;
}


/**
 * Установка кнопки отправки формы в АКТИВНОЕ состояние
 * */
function setSubmitButtonEnabled(){
    document.getElementById("check-button").disabled = false;
}