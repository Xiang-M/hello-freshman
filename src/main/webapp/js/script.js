// 每次点击这个按钮时，都会播放一个简短的音效
document.addEventListener('DOMContentLoaded', function() {
    // 播放音效
    const playSound = function() {
        const soundEffect = document.getElementById('soundEffect');
        if (soundEffect) {
            soundEffect.currentTime = 0;
            soundEffect.play().catch(e => console.log('音效播放失败:', e));
        }
    };

    // 为随机展示按钮添加点击事件
    const nextButton = document.querySelector('form input[value="next"]').parentNode;
    nextButton.addEventListener('click', playSound);
});