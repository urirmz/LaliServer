const scrollElements = document.querySelectorAll(".appear-on-scroll");
const scrollOffsetInPercentage = 100;

function elementInView(element, percentageScroll) {
    let elementTop = element.getBoundingClientRect().top;
    return elementTop <= ((window.innerHeight || document.documentElement.clientHeight) * (percentageScroll/100));
};

function displayScrollElement(element) {
    element.style.opacity = 1;
};

function hideScrollElement(element) {
    element.style.opacity = 0;
};

function handleScrollAnimation() {
    scrollElements.forEach((element) => {
      if (elementInView(element, scrollOffsetInPercentage)) {
        displayScrollElement(element);
      } else {
        hideScrollElement(element);
      }
    });
}

window.addEventListener('scroll', () => {
    handleScrollAnimation();
});