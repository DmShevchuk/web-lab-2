const BASE_URL = "http://localhost:8080/Gradle___com_example___web_lab_2_1_0_SNAPSHOT_war/main";

const clearHistoryButton = document.getElementById("table-clear-button");
clearHistoryButton.addEventListener('click', createRequestToClearHistory);


function getUrlWithQueryParam(queryParam){
    let url = new URL(BASE_URL);
    url.searchParams.set("q", queryParam);
    return url;
}

function createRequestToClearHistory() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', getUrlWithQueryParam("history"));

    xhr.send();
}


