window.onload = function() {
  setInterval(function() {
    document
      .getElementById("welcome-header")
      .classList.remove("vertical-translate");
    document
      .getElementById("welcome-desc")
      .classList.remove("vertical-translate");
  }, 250);
  setInterval(function() {
    document.getElementById("welcome-header").classList.remove("fade");
    document.getElementById("welcome-desc").classList.remove("fade");
  }, 450);
};
