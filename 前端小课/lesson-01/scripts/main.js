let myHeading = document.querySelector('h1');
myHeading.textContent = '欢迎加入字节跳动';

// 事件
/*document.querySelector('html').onclick = function () {
    alert('恭喜加入字节大家庭，🎉🎉🎉');
}*/

// 同等上
let htmlEvent = document.querySelector('html');
htmlEvent.onclick = function () {
    alert('恭喜加入字节大家庭，🎉🎉🎉');
}

// 点击图片换图
let imgEvent = document.querySelector('img');
imgEvent.onclick = function () {
    let src = imgEvent.getAttribute('src');
    if (src === 'image/a.png') {
        imgEvent.setAttribute('src', 'image/b.png');
    }
    else {
        imgEvent.setAttribute('src', 'image/a.png');
    }
}

// 切换欢迎语
let btn = document.querySelector('button');
btn.onclick = function () {
    setUserName();
}
function setUserName() {
    let myName = prompt('请输入名字');
    if (!myName || myName === null) {
        setUserName();
    }
    else {
        localStorage.setItem('name', myName);
        myHeading.textContent = '欢迎' + myName + '加入字节跳动';
    }
}
