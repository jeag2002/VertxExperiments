
function init(){
	loadAdvertisement();
}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};


function loadAdvertisement() {
    var xmlhttp = (window.XMLHttpRequest) ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                document.getElementById('parent').innerHTML = xmlhttp.responseText;
            } else {
                document.getElementById('parent').innerHTML = '';
            }
        }
    };
    
    var size = getUrlParameter('size');
    if (size===''){
    	size = '320x50';
    }
    xmlhttp.open("GET", "http://localhost:8080/adv/"+size);
    xmlhttp.send();
};