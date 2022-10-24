let drawDots = (shootList) => {
    console.log(shootList)
    if (shootList.length !== 0) {
        shootList.forEach(attempt => {
            if (attempt["result"]){
                drawDot(attempt["x"], attempt["y"], attempt["r"], "#73ff00");
            }else{
                drawDot(attempt["x"], attempt["y"], attempt["r"], "#FF0000FF");
            }
        })
    }
}