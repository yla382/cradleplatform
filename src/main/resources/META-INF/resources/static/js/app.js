window.onload = function () {
    //Background animation during scroll
    var img = document.getElementById("welcome-background");
    var bodyHeight = window.pageYOffset;

    window.addEventListener("scroll", function () {
        var scroll = this.scrollY;
        img.style.transform = "rotate(" + scroll / 60 + "deg)";

        if (scroll >= window.innerHeight) {
            setInterval(function () {
                document.getElementById("welcome-details-info").classList.remove("vertical-translate");
            }, 350);
            setInterval(function () {
                document.getElementById("welcome-details-info").classList.remove("fade");
            }, 150);
            setInterval(function () {
                document.getElementById("welcome-details-about").classList.remove("vertical-translate");
            }, 1350);
            setInterval(function () {
                document.getElementById("welcome-details-about").classList.remove("fade");
            }, 1050);
            setInterval(function () {
                document.getElementById("welcome-details-start").classList.remove("fade");
            }, 1950);
        }
    });

    //Onload animations
    document.getElementById("welcome-hero").classList.remove("fade");
    document.getElementById("welcome-background").classList.remove("fade");

    setInterval(function () {
        document
            .getElementById("welcome-title-desc")
            .classList.remove("horizontal-translate");
    }, 650);
    setInterval(function () {
        document.getElementById("welcome-title-desc").classList.remove("fade");
    }, 850);
};