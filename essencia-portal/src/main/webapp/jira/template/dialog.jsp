<!-- Render the warning dialog -->
<section role="dialog" id="warning-dialog" class="aui-layer aui-dialog2 aui-dialog2-medium aui-dialog2-warning"
         aria-hidden="true">
    <!-- Dialog header -->
    <header class="aui-dialog2-header">
        <!-- The dialog's title -->
        <h2 class="aui-dialog2-header-main">Essencia Warning</h2>

        <!-- Close icon -->
        <a class="aui-dialog2-header-close">
            <span class="aui-icon aui-icon-small aui-iconfont-close-dialog">Close</span>
        </a>
    </header>
    <!-- Main dialog content -->
    <div class="aui-dialog2-content">
        <p name="msg"></p>
    </div>
    <!-- Dialog footer -->
    <footer class="aui-dialog2-footer">
        <!-- Actions to render on the right of the footer -->
        <div class="aui-dialog2-footer-actions">
            <button name="close-button" class="aui-button aui-button-link">Close</button>
        </div>
        <!-- Hint text is rendered on the left of the footer -->
        <div class="aui-dialog2-footer-hint">Essencia warning</div>
    </footer>
</section>


<!-- Render the dialog -->
<section role="dialog" id="normal-dialog" class="aui-layer aui-dialog2 aui-dialog2-medium" aria-hidden="true">
    <!-- Dialog header -->
    <header class="aui-dialog2-header">
        <!-- The dialog's title -->
        <h2 class="aui-dialog2-header-main">Always use sentence case</h2>
        <!-- Actions to render on the right of the header -->
        <div class="aui-dialog2-header-secondary">
            <form class="aui" action="#">
                <input class="text" type="search" name="search">
            </form>
        </div>
        <!-- Close icon -->
        <a class="aui-dialog2-header-close">
            <span class="aui-icon aui-icon-small aui-iconfont-close-dialog">Close</span>
        </a>
    </header>
    <!-- Main dialog content -->
    <div class="aui-dialog2-content">
        <p name="msg"></p>
    </div>
    <!-- Dialog footer -->
    <footer class="aui-dialog2-footer">
        <!-- Actions to render on the right of the footer -->
        <div class="aui-dialog2-footer-actions">
            <button name="submit-button" class="aui-button aui-button-primary">OK</button>
            <button name="next-button" class="aui-button">Next</button>
            <button name="close-button" class="aui-button aui-button-link">Close</button>
        </div>
        <!-- Hint text is rendered on the left of the footer -->
        <div class="aui-dialog2-footer-hint">this is a hint</div>
    </footer>
</section>