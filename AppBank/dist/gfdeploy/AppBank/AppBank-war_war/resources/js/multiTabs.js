/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('#tabs').each(function(){
        var $active, $content, $links = $(this).find('a');
        $active = $($links.filter('[href="'+location.hash+'"]')[0] || $links[0]);
        $active.parent().addClass('active');
        $content = $($active.attr('href'));
        $content.show();
    });
       
    $("#tabs li").click(function() {
        $("#tabs li").removeClass('active');
        $(this).addClass("active");
        $(".tab_content").hide();
        var selected_tab = $(this).find("a").attr("href");      
        var starting = selected_tab.indexOf("#");
        var sub = selected_tab.substring(starting);
        $(sub).fadeIn();
        return false;
    });
});
