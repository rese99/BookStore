let province;
let city;
let country;
let town;

let provinceName;
let cityName;
let countryName;

//遍历省份
function provinceList() {
    for (let i = 0; i < province.length; i++) {
        //Dom操作 添加省份
        $("#province").append("<option id='" + province[i].areaId + "'>" + province[i].areaName + "</option>");
    }
    //初始化
//省份选择处理
    provinceList1();
    $("#province:first").change(function () {
        provinceList1();
    });
}

function provinceList1() {
    $("#city").find("option").remove();
    $("#country").find("option").remove();
    $("#town").find("option").remove();
    //获取以选择的省份
    provinceName = $("#province:first").val();

    //遍历省份
    for (let i = 0; i < province.length; i++) {
        //判断对应省份
        if (province[i].areaName === provinceName) {
            city = province[i].areaList;
            break;
        }
    }
    //遍历城市
    for (let i = 0; i < city.length; i++) {
        //Dom操作 添加城市
        $("#city").append("<option id='" + city[i].areaId + "'>" + city[i].areaName + "</option>");
    }
    reload_country();
}

//重新加载js //城市选择处理
function reload_country() {
    reload_country1();
    //城市选择处理
    $("#city:first").change(function () {
        reload_country1();
    });
}

function reload_country1() {
    $("#country").find("option").remove();
    $("#town").find("option").remove();
    //获取以选择的城市
    cityName = $("#city:first").val();

    //遍历城市
    for (let i = 0; i < city.length; i++) {
        //判断对应城市
        if (city[i].areaName === cityName) {
            country = city[i].areaList;
            break;
        }
    }
    //遍历地区
    for (let i = 0; i < country.length; i++) {
        //Dom操作 添加城市
        $("#country").append("<option id='" + country[i].areaId + "'>" + country[i].areaName + "</option>");
    }
    reload_town();
}


//重新加载js //地区选择处理
function reload_town() {
    //地区选择处理
    reload_town1();
    $("#country:first").change(function () {
        reload_town1()
    });
}

function reload_town1() {
    $("#town").find("option").remove();
    //获取以选择的地区
    countryName = $("#country:first").val();

    //遍历地区
    for (let i = 0; i < country.length; i++) {
        //判断对应地区
        if (country[i].areaName === countryName) {
            town = country[i].areaList;
            break;
        }
    }
    //无城镇信息
    if (town.length === 0) {
        return;
    }
    //遍历城镇
    for (let i = 0; i < town.length; i++) {
        //Dom操作 添加城镇
        $("#town").append("<option id='" + town[i].areaId + "'>" + town[i].areaName + "</option>");
    }
}