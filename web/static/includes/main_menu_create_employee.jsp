
<div class="title-bar" data-responsive-toggle="main-menu" data-hide-for="medium">
    <button class="menu-icon" type="button" data-toggle></button>
    <div class="title-bar-title">Menu</div>
</div>

<div class="top-bar" id="main-menu">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <a href="${pageContext.request.contextPath}/home">
                <li class="menu-text"> Bayport Corp.</li>
            </a>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="menu" data-responsive-menu="drilldown medium-dropdown">
            <li class="has-submenu">
                <a href="#">Home</a>
                <ul class="submenu menu vertical" data-submenu>
                    <li><a href="#">One</a></li>
                    <li><a href="#">Two</a></li>
                    <li><a href="#">Three</a></li>
                </ul>
            </li>
            <li><a href="#">Two</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </div>
</div>