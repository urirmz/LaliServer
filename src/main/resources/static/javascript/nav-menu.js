const menu = document.querySelector(".nav-menu");
const menuItems = document.querySelectorAll(".nav-menu-link");
const menuButton= document.querySelector(".nav-menu-button");
const closeButton= document.querySelector(".close-menu");
const openMenu = document.querySelector(".open-menu");
const musicPlayer = document.querySelector(".music-player");

function toggleMenu() {
  if (menu.classList.contains("show-nav-menu")) {
    menu.classList.remove("show-nav-menu");
    closeButton.style.display = "none";
    openMenu.style.display = "block";
    musicPlayer.style.display = "flex";
  } else {
    menu.classList.add("show-nav-menu");
    closeButton.style.display = "block";
    openMenu.style.display = "none";
    musicPlayer.style.display = "none";
  }
}

menuButton.addEventListener("click", toggleMenu);

menuItems.forEach( 
    function(menuItem) { 
      menuItem.addEventListener("click", toggleMenu);
    }
)