function getDiff() {
    const currDay = new Date();
    const birthDay = new Date(`${currDay.getFullYear()}-08-10`);

    const diffDays = Math.floor((birthDay.getTime() - currDay.getTime()) / (1000 * 60 * 60 * 24));
    document.write(`생일까지 ${diffDays < 10 ? `0${diffDays}` : diffDays}일 남았습니다.`);
}


function getTime() {
    const xmasDay = new Date("2021-08-10");
    const currDay = new Date();

    let diff = xmasDay - currDay;
    const diffDays = Math.floor((xmasDay.getTime() - currDay.getTime()) / (1000 * 60 * 60 * 24));
    diff -= diffDays * (1000 * 60 * 60 * 24);
    const diffHours = Math.floor(diff / (1000 * 60 * 60));
    diff -= diffHours * (1000 * 60 * 60);
    const diffMin = Math.floor(diff / (1000 * 60));
    diff -= diffMin * (1000 * 60);
    const diffSec = Math.floor(diff / 1000);

    document.write(`${diffDays < 10 ? `0${diffDays}` : diffDays}일 ${diffHours < 10 ? `0${diffHours}` : diffHours}시간 ${diffMin < 10 ? `0${diffMin}` : diffMin}분 ${diffSec < 10 ? `0${diffSec}` : diffSec}초`);

}

// const countDownTimer = function (id, date) {
//     var _vDate = new Date(date); // 전달 받은 일자
//     var _second = 1000;
//     var _minute = _second * 60;
//     var _hour = _minute * 60;
//     var _day = _hour * 24;
//     var timer;
//
//     function showRemaining() {
//         const now = new Date();
//         var distDt = _vDate - now;
//         if (distDt < 0) {
//             clearInterval(timer);
//             document.getElementById(id).textContent = '오늘은 민정이의 생일입니다!';
//             return;
//         }
//         const days = Math.floor(distDt / _day);
//         const hours = Math.floor((distDt % _day) / _hour);
//         const minutes = Math.floor((distDt % _hour) / _minute);
//         const seconds = Math.floor((distDt % _minute) / _second);
//         document.getElementById(id).textContent = date.toLocaleString() + "까지 : ";
//         document.getElementById(id).textContent = days + '일 ';
//         document.getElementById(id).textContent += hours + '시간 ';
//         document.getElementById(id).textContent += minutes + '분 ';
//         document.getElementById(id).textContent += seconds + '초';
//     }
//
//     timer = setInterval(showRemaining, 1000);
// }
// const dateObj = new Date();
// dateObj.setDate(dateObj.getDate() + 1);
// countDownTimer('sample01', dateObj); // 내일까지
// countDownTimer('sample02', '08/10/2021 00:00 AM'); // 2024년 4월 1일까지, 시간을 표시하려면 01:00 AM과 같은 형식을 사용한다.
// countDownTimer('sample03', '04/01/2024');// 2024년 4월 1일까지
// countDownTimer('sample04', '04/01/2019');// 2024년 4월 1일까지

CountDownTimer('12/25/2019', 'countdown');

CountDownTimer('3/19/2019 5:00 PM', 'HourCountdown');

CountDownTimer('2/19/2019', 'countExpire');



function CountDownTimer(dt, id) {

    var end = new Date(dt);



    var _second = 1000;

    var _minute = _second * 60;

    var _hour = _minute * 60;

    var _day = _hour * 24;

    var timer;



    function showRemaining() {

        var now = new Date();

        var distance = end - now;



        // 시간 종료 시 뜨는 문구

        if (distance < 0) {

            clearInterval(timer);

            document.getElementById(id).innerHTML = '오늘은 민정이의 생일입니다!';

            return;

        }

        var days = Math.floor(distance / _day);

        var hours = Math.floor((distance % _day) / _hour);

        var minutes = Math.floor((distance % _hour) / _minute);

        var seconds = Math.floor((distance % _minute) / _second);



        document.getElementById(id).innerHTML = '민정이의 생일까지 ' + days + '일 ';

        document.getElementById(id).innerHTML += hours + '시간 ';

        document.getElementById(id).innerHTML += minutes + '분 ';

        document.getElementById(id).innerHTML += seconds + '초 ' + '남았습니다!';

    }

    timer = setInterval(showRemaining, 1000);

}