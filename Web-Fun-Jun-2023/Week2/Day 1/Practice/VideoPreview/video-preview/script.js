console.log("page loaded...");


const video = document.querySelector('video');

function previewVideo(play) {
    if (play) {
        video.muted = true;
        video.play();
    } else {
        video.muted = false;
        video.pause();
    }
}