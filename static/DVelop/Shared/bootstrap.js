﻿if(!jQuery)throw new Error("Bootstrap requires jQuery");+function(n){"use strict";function t(){var i=document.createElement("bootstrap"),n={WebkitTransition:"webkitTransitionEnd",MozTransition:"transitionend",OTransition:"oTransitionEnd otransitionend",transition:"transitionend"};for(var t in n)if(i.style[t]!==undefined)return{end:n[t]}}n.fn.emulateTransitionEnd=function(t){var i=!1,u=this,r;n(this).one(n.support.transition.end,function(){i=!0});return r=function(){i||n(u).trigger(n.support.transition.end)},setTimeout(r,t),this};n(function(){n.support.transition=t()})}(window.jQuery);+function(n){"use strict";var i='[data-dismiss="alert"]',t=function(t){n(t).on("click",i,this.close)},r;t.prototype.close=function(t){function f(){i.trigger("closed.bs.alert").remove()}var u=n(this),r=u.attr("data-target"),i;(r||(r=u.attr("href"),r=r&&r.replace(/.*(?=#[^\s]*$)/,"")),i=n(r),t&&t.preventDefault(),i.length||(i=u.hasClass("alert")?u:u.parent()),i.trigger(t=n.Event("close.bs.alert")),t.isDefaultPrevented())||(i.removeClass("in"),n.support.transition&&i.hasClass("fade")?i.one(n.support.transition.end,f).emulateTransitionEnd(150):f())};r=n.fn.alert;n.fn.alert=function(i){return this.each(function(){var r=n(this),u=r.data("bs.alert");u||r.data("bs.alert",u=new t(this));typeof i=="string"&&u[i].call(r)})};n.fn.alert.Constructor=t;n.fn.alert.noConflict=function(){return n.fn.alert=r,this};n(document).on("click.bs.alert.data-api",i,t.prototype.close)}(window.jQuery);+function(n){"use strict";var t=function(i,r){this.$element=n(i);this.options=n.extend({},t.DEFAULTS,r)},i;t.DEFAULTS={loadingText:"loading..."};t.prototype.setState=function(n){var i="disabled",t=this.$element,r=t.is("input")?"val":"html",u=t.data();n=n+"Text";u.resetText||t.data("resetText",t[r]());t[r](u[n]||this.options[n]);setTimeout(function(){n=="loadingText"?t.addClass(i).attr(i,i):t.removeClass(i).removeAttr(i)},0)};t.prototype.toggle=function(){var n=this.$element.closest('[data-toggle="buttons"]'),t;n.length&&(t=this.$element.find("input").prop("checked",!this.$element.hasClass("active")).trigger("change"),t.prop("type")==="radio"&&n.find(".active").removeClass("active"));this.$element.toggleClass("active")};i=n.fn.button;n.fn.button=function(i){return this.each(function(){var u=n(this),r=u.data("bs.button"),f=typeof i=="object"&&i;r||u.data("bs.button",r=new t(this,f));i=="toggle"?r.toggle():i&&r.setState(i)})};n.fn.button.Constructor=t;n.fn.button.noConflict=function(){return n.fn.button=i,this};n(document).on("click.bs.button.data-api","[data-toggle^=button]",function(t){var i=n(t.target);i.hasClass("btn")||(i=i.closest(".btn"));i.button("toggle");t.preventDefault()})}(window.jQuery);+function(n){"use strict";var t=function(t,i){this.$element=n(t);this.$indicators=this.$element.find(".carousel-indicators");this.options=i;this.paused=this.sliding=this.interval=this.$active=this.$items=null;this.options.pause=="hover"&&this.$element.on("mouseenter",n.proxy(this.pause,this)).on("mouseleave",n.proxy(this.cycle,this))},i;t.DEFAULTS={interval:5e3,pause:"hover",wrap:!0};t.prototype.cycle=function(t){return t||(this.paused=!1),this.interval&&clearInterval(this.interval),this.options.interval&&!this.paused&&(this.interval=setInterval(n.proxy(this.next,this),this.options.interval)),this};t.prototype.getActiveIndex=function(){return this.$active=this.$element.find(".item.active"),this.$items=this.$active.parent().children(),this.$items.index(this.$active)};t.prototype.to=function(t){var r=this,i=this.getActiveIndex();if(!(t>this.$items.length-1)&&!(t<0))return this.sliding?this.$element.one("slid",function(){r.to(t)}):i==t?this.pause().cycle():this.slide(t>i?"next":"prev",n(this.$items[t]))};t.prototype.pause=function(t){return t||(this.paused=!0),this.$element.find(".next, .prev").length&&n.support.transition.end&&(this.$element.trigger(n.support.transition.end),this.cycle(!0)),this.interval=clearInterval(this.interval),this};t.prototype.next=function(){if(!this.sliding)return this.slide("next")};t.prototype.prev=function(){if(!this.sliding)return this.slide("prev")};t.prototype.slide=function(t,i){var u=this.$element.find(".item.active"),r=i||u[t](),s=this.interval,f=t=="next"?"left":"right",h=t=="next"?"first":"last",o=this,e;if(!r.length){if(!this.options.wrap)return;r=this.$element.find(".item")[h]()}if(this.sliding=!0,s&&this.pause(),e=n.Event("slide.bs.carousel",{relatedTarget:r[0],direction:f}),!r.hasClass("active")){if(this.$indicators.length){this.$indicators.find(".active").removeClass("active");this.$element.one("slid",function(){var t=n(o.$indicators.children()[o.getActiveIndex()]);t&&t.addClass("active")})}if(n.support.transition&&this.$element.hasClass("slide")){if(this.$element.trigger(e),e.isDefaultPrevented())return;r.addClass(t);r[0].offsetWidth;u.addClass(f);r.addClass(f);u.one(n.support.transition.end,function(){r.removeClass([t,f].join(" ")).addClass("active");u.removeClass(["active",f].join(" "));o.sliding=!1;setTimeout(function(){o.$element.trigger("slid")},0)}).emulateTransitionEnd(600)}else{if(this.$element.trigger(e),e.isDefaultPrevented())return;u.removeClass("active");r.addClass("active");this.sliding=!1;this.$element.trigger("slid")}return s&&this.cycle(),this}};i=n.fn.carousel;n.fn.carousel=function(i){return this.each(function(){var u=n(this),r=u.data("bs.carousel"),f=n.extend({},t.DEFAULTS,u.data(),typeof i=="object"&&i),e=typeof i=="string"?i:f.slide;r||u.data("bs.carousel",r=new t(this,f));typeof i=="number"?r.to(i):e?r[e]():f.interval&&r.pause().cycle()})};n.fn.carousel.Constructor=t;n.fn.carousel.noConflict=function(){return n.fn.carousel=i,this};n(document).on("click.bs.carousel.data-api","[data-slide], [data-slide-to]",function(t){var i=n(this),f,r=n(i.attr("data-target")||(f=i.attr("href"))&&f.replace(/.*(?=#[^\s]+$)/,"")),e=n.extend({},r.data(),i.data()),u=i.attr("data-slide-to");u&&(e.interval=!1);r.carousel(e);(u=i.attr("data-slide-to"))&&r.data("bs.carousel").to(u);t.preventDefault()});n(window).on("load",function(){n('[data-ride="carousel"]').each(function(){var t=n(this);t.carousel(t.data())})})}(window.jQuery);+function(n){"use strict";var t=function(i,r){this.$element=n(i);this.options=n.extend({},t.DEFAULTS,r);this.transitioning=null;this.options.parent&&(this.$parent=n(this.options.parent));this.options.toggle&&this.toggle()},i;t.DEFAULTS={toggle:!0};t.prototype.dimension=function(){var n=this.$element.hasClass("width");return n?"width":"height"};t.prototype.show=function(){var u,t,r,i,f,e;if(!this.transitioning&&!this.$element.hasClass("in")&&(u=n.Event("show.bs.collapse"),this.$element.trigger(u),!u.isDefaultPrevented())){if(t=this.$parent&&this.$parent.find("> .panel > .in"),t&&t.length){if(r=t.data("bs.collapse"),r&&r.transitioning)return;t.collapse("hide");r||t.data("bs.collapse",null)}if(i=this.dimension(),this.$element.removeClass("collapse").addClass("collapsing")[i](0),this.transitioning=1,f=function(){this.$element.removeClass("collapsing").addClass("in")[i]("auto");this.transitioning=0;this.$element.trigger("shown.bs.collapse")},!n.support.transition)return f.call(this);e=n.camelCase(["scroll",i].join("-"));this.$element.one(n.support.transition.end,n.proxy(f,this)).emulateTransitionEnd(350)[i](this.$element[0][e])}};t.prototype.hide=function(){var i,t,r;if(!this.transitioning&&this.$element.hasClass("in")&&(i=n.Event("hide.bs.collapse"),this.$element.trigger(i),!i.isDefaultPrevented())){if(t=this.dimension(),this.$element[t](this.$element[t]())[0].offsetHeight,this.$element.addClass("collapsing").removeClass("collapse").removeClass("in"),this.transitioning=1,r=function(){this.transitioning=0;this.$element.trigger("hidden.bs.collapse").removeClass("collapsing").addClass("collapse")},!n.support.transition)return r.call(this);this.$element[t](0).one(n.support.transition.end,n.proxy(r,this)).emulateTransitionEnd(350)}};t.prototype.toggle=function(){this[this.$element.hasClass("in")?"hide":"show"]()};i=n.fn.collapse;n.fn.collapse=function(i){return this.each(function(){var r=n(this),u=r.data("bs.collapse"),f=n.extend({},t.DEFAULTS,r.data(),typeof i=="object"&&i);u||r.data("bs.collapse",u=new t(this,f));typeof i=="string"&&u[i]()})};n.fn.collapse.Constructor=t;n.fn.collapse.noConflict=function(){return n.fn.collapse=i,this};n(document).on("click.bs.collapse.data-api","[data-toggle=collapse]",function(t){var i=n(this),e,s=i.attr("data-target")||t.preventDefault()||(e=i.attr("href"))&&e.replace(/.*(?=#[^\s]+$)/,""),r=n(s),u=r.data("bs.collapse"),h=u?"toggle":i.data(),f=i.attr("data-parent"),o=f&&n(f);u&&u.transitioning||(o&&o.find('[data-toggle=collapse][data-parent="'+f+'"]').not(i).addClass("collapsed"),i[r.hasClass("in")?"addClass":"removeClass"]("collapsed"));r.collapse(h)})}(window.jQuery);+function(n){"use strict";function r(){n(e).remove();n(i).each(function(t){var i=u(n(this));i.hasClass("open")&&((i.trigger(t=n.Event("hide.bs.dropdown")),t.isDefaultPrevented())||i.removeClass("open").trigger("hidden.bs.dropdown"))})}function u(t){var i=t.attr("data-target"),r;return i||(i=t.attr("href"),i=i&&/#/.test(i)&&i.replace(/.*(?=#[^\s]*$)/,"")),r=i&&n(i),r&&r.length?r:t.parent()}var e=".dropdown-backdrop",i="[data-toggle=dropdown]",t=function(t){var i=n(t).on("click.bs.dropdown",this.toggle)},f;t.prototype.toggle=function(t){var f=n(this),i,e;if(!f.is(".disabled, :disabled")){if(i=u(f),e=i.hasClass("open"),r(),!e){if("ontouchstart"in document.documentElement)n('<div class="dropdown-backdrop"/>').insertAfter(n(this)).on("click",r);if(i.trigger(t=n.Event("show.bs.dropdown")),t.isDefaultPrevented())return;i.toggleClass("open").trigger("shown.bs.dropdown")}return f.focus(),!1}};t.prototype.keydown=function(t){var e,o,s,f,r;if(/(38|40|27)/.test(t.keyCode)&&(e=n(this),t.preventDefault(),t.stopPropagation(),!e.is(".disabled, :disabled"))){if(o=u(e),s=o.hasClass("open"),!s||s&&t.keyCode==27)return t.which==27&&o.find(i).focus(),e.click();(f=n("[role=menu] li:not(.divider):visible a",o),f.length)&&(r=f.index(f.filter(":focus")),t.keyCode==38&&r>0&&r--,t.keyCode==40&&r<f.length-1&&r++,~r||(r=0),f.eq(r).focus())}};f=n.fn.dropdown;n.fn.dropdown=function(i){return this.each(function(){var r=n(this),u=r.data("dropdown");u||r.data("dropdown",u=new t(this));typeof i=="string"&&u[i].call(r)})};n.fn.dropdown.Constructor=t;n.fn.dropdown.noConflict=function(){return n.fn.dropdown=f,this};n(document).on("click.bs.dropdown.data-api",r).on("click.bs.dropdown.data-api",".dropdown form",function(n){n.stopPropagation()}).on("click.bs.dropdown.data-api",i,t.prototype.toggle).on("keydown.bs.dropdown.data-api",i+", [role=menu]",t.prototype.keydown)}(window.jQuery);+function(n){"use strict";var t=function(t,i){this.options=i;this.$element=n(t).on("click.dismiss.modal",'[data-dismiss="modal"]',n.proxy(this.hide,this));this.$backdrop=this.isShown=null;this.options.remote&&this.$element.load(this.options.remote)},i;t.DEFAULTS={backdrop:!0,keyboard:!0,show:!0};t.prototype.toggle=function(n){return this[this.isShown?"hide":"show"](n)};t.prototype.show=function(t){var i=this,r=n.Event("show.bs.modal",{relatedTarget:t});(this.$element.trigger(r),this.isShown||r.isDefaultPrevented())||(this.isShown=!0,this.escape(),this.backdrop(function(){var u=n.support.transition&&i.$element.hasClass("fade"),r;i.$element.parent().length||i.$element.appendTo(document.body);i.$element.show();u&&i.$element[0].offsetWidth;i.$element.addClass("in").attr("aria-hidden",!1);i.enforceFocus();r=n.Event("shown.bs.modal",{relatedTarget:t});u?i.$element.one(n.support.transition.end,function(){i.$element.focus().trigger(r)}).emulateTransitionEnd(300):i.$element.focus().trigger(r)}))};t.prototype.hide=function(t){(t&&t.preventDefault(),t=n.Event("hide.bs.modal"),this.$element.trigger(t),this.isShown&&!t.isDefaultPrevented())&&(this.isShown=!1,this.escape(),n(document).off("focusin.bs.modal"),this.$element.removeClass("in").attr("aria-hidden",!0),n.support.transition&&this.$element.hasClass("fade")?this.$element.one(n.support.transition.end,n.proxy(this.hideModal,this)).emulateTransitionEnd(300):this.hideModal())};t.prototype.enforceFocus=function(){n(document).off("focusin.bs.modal").on("focusin.bs.modal",n.proxy(function(n){this.$element[0]===n.target||this.$element.has(n.target).length||this.$element.focus()},this))};t.prototype.escape=function(){if(this.isShown&&this.options.keyboard)this.$element.on("keyup.dismiss.bs.modal",n.proxy(function(n){n.which==27&&this.hide()},this));else this.isShown||this.$element.off("keyup.dismiss.bs.modal")};t.prototype.hideModal=function(){var n=this;this.$element.hide();this.backdrop(function(){n.removeBackdrop();n.$element.trigger("hidden.bs.modal")})};t.prototype.removeBackdrop=function(){this.$backdrop&&this.$backdrop.remove();this.$backdrop=null};t.prototype.backdrop=function(t){var u=this,r=this.$element.hasClass("fade")?"fade":"",i;if(this.isShown&&this.options.backdrop){i=n.support.transition&&r;this.$backdrop=n('<div class="modal-backdrop '+r+'" />').appendTo(document.body);this.$element.on("click.dismiss.modal",n.proxy(function(n){n.target===n.currentTarget&&(this.options.backdrop=="static"?this.$element[0].focus.call(this.$element[0]):this.hide.call(this))},this));if(i&&this.$backdrop[0].offsetWidth,this.$backdrop.addClass("in"),!t)return;i?this.$backdrop.one(n.support.transition.end,t).emulateTransitionEnd(150):t()}else!this.isShown&&this.$backdrop?(this.$backdrop.removeClass("in"),n.support.transition&&this.$element.hasClass("fade")?this.$backdrop.one(n.support.transition.end,t).emulateTransitionEnd(150):t()):t&&t()};i=n.fn.modal;n.fn.modal=function(i,r){return this.each(function(){var f=n(this),u=f.data("bs.modal"),e=n.extend({},t.DEFAULTS,f.data(),typeof i=="object"&&i);u||f.data("bs.modal",u=new t(this,e));typeof i=="string"?u[i](r):e.show&&u.show(r)})};n.fn.modal.Constructor=t;n.fn.modal.noConflict=function(){return n.fn.modal=i,this};n(document).on("click.bs.modal.data-api",'[data-toggle="modal"]',function(t){var i=n(this),r=i.attr("href"),u=n(i.attr("data-target")||r&&r.replace(/.*(?=#[^\s]+$)/,"")),f=u.data("modal")?"toggle":n.extend({remote:!/#/.test(r)&&r},u.data(),i.data());t.preventDefault();u.modal(f,this).one("hide",function(){i.is(":visible")&&i.focus()})});n(document).on("shown.bs.modal",".modal",function(){n(document.body).addClass("modal-open")}).on("hidden.bs.modal",".modal",function(){n(document.body).removeClass("modal-open")})}(window.jQuery);+function(n){"use strict";var t=function(n,t){this.type=this.options=this.enabled=this.timeout=this.hoverState=this.$element=null;this.init("tooltip",n,t)},i;t.DEFAULTS={animation:!0,placement:"top",selector:!1,template:'<div class="tooltip"><div class="tooltip-arrow"><\/div><div class="tooltip-inner"><\/div><\/div>',trigger:"hover focus",title:"",delay:0,html:!1,container:!1};t.prototype.init=function(t,i,r){var f,e,u,o,s;for(this.enabled=!0,this.type=t,this.$element=n(i),this.options=this.getOptions(r),f=this.options.trigger.split(" "),e=f.length;e--;)if(u=f[e],u=="click")this.$element.on("click."+this.type,this.options.selector,n.proxy(this.toggle,this));else if(u!="manual"){o=u=="hover"?"mouseenter":"focus";s=u=="hover"?"mouseleave":"blur";this.$element.on(o+"."+this.type,this.options.selector,n.proxy(this.enter,this));this.$element.on(s+"."+this.type,this.options.selector,n.proxy(this.leave,this))}this.options.selector?this._options=n.extend({},this.options,{trigger:"manual",selector:""}):this.fixTitle()};t.prototype.getDefaults=function(){return t.DEFAULTS};t.prototype.getOptions=function(t){return t=n.extend({},this.getDefaults(),this.$element.data(),t),t.delay&&typeof t.delay=="number"&&(t.delay={show:t.delay,hide:t.delay}),t};t.prototype.getDelegateOptions=function(){var t={},i=this.getDefaults();return this._options&&n.each(this._options,function(n,r){i[n]!=r&&(t[n]=r)}),t};t.prototype.enter=function(t){var i=t instanceof this.constructor?t:n(t.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type);if(clearTimeout(i.timeout),!i.options.delay||!i.options.delay.show)return i.show();i.hoverState="in";i.timeout=setTimeout(function(){i.hoverState=="in"&&i.show()},i.options.delay.show)};t.prototype.leave=function(t){var i=t instanceof this.constructor?t:n(t.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type);if(clearTimeout(i.timeout),!i.options.delay||!i.options.delay.hide)return i.hide();i.hoverState="out";i.timeout=setTimeout(function(){i.hoverState=="out"&&i.hide()},i.options.delay.hide)};t.prototype.show=function(){var o=n.Event("show.bs."+this.type),i,l;if(this.hasContent()&&this.enabled){if(this.$element.trigger(o),o.isDefaultPrevented())return;i=this.tip();this.setContent();this.options.animation&&i.addClass("fade");var t=typeof this.options.placement=="function"?this.options.placement.call(this,i[0],this.$element[0]):this.options.placement,s=/\s?auto?\s?/i,h=s.test(t);h&&(t=t.replace(s,"")||"top");i.detach().css({top:0,left:0,display:"block"}).addClass(t);this.options.container?i.appendTo(this.options.container):i.insertAfter(this.$element);var r=this.getPosition(),u=i[0].offsetWidth,f=i[0].offsetHeight;if(h){var e=this.$element.parent(),a=t,c=document.documentElement.scrollTop||document.body.scrollTop,v=this.options.container=="body"?window.innerWidth:e.outerWidth(),y=this.options.container=="body"?window.innerHeight:e.outerHeight(),p=this.options.container=="body"?0:e.offset().left;t=t=="bottom"&&r.top+r.height+f-c>y?"top":t=="top"&&r.top-c-f<0?"bottom":t=="right"&&r.right+u>v?"left":t=="left"&&r.left-u<p?"right":t;i.removeClass(a).addClass(t)}l=this.getCalculatedOffset(t,r,u,f);this.applyPlacement(l,t);this.$element.trigger("shown.bs."+this.type)}};t.prototype.applyPlacement=function(n,t){var h,i=this.tip(),c=i[0].offsetWidth,f=i[0].offsetHeight,e=parseInt(i.css("margin-top"),10),o=parseInt(i.css("margin-left"),10),u,r,s;isNaN(e)&&(e=0);isNaN(o)&&(o=0);n.top=n.top+e;n.left=n.left+o;i.offset(n).addClass("in");u=i[0].offsetWidth;r=i[0].offsetHeight;t=="top"&&r!=f&&(h=!0,n.top=n.top+f-r);/bottom|top/.test(t)?(s=0,n.left<0&&(s=n.left*-2,n.left=0,i.offset(n),u=i[0].offsetWidth,r=i[0].offsetHeight),this.replaceArrow(s-c+u,u,"left")):this.replaceArrow(r-f,r,"top");h&&i.offset(n)};t.prototype.replaceArrow=function(n,t,i){this.arrow().css(i,n?50*(1-n/t)+"%":"")};t.prototype.setContent=function(){var n=this.tip(),t=this.getTitle();n.find(".tooltip-inner")[this.options.html?"html":"text"](t);n.removeClass("fade in top bottom left right")};t.prototype.hide=function(){function r(){t.detach()}var u=this,t=this.tip(),i=n.Event("hide.bs."+this.type);if(this.$element.trigger(i),!i.isDefaultPrevented())return t.removeClass("in"),n.support.transition&&this.$tip.hasClass("fade")?t.one(n.support.transition.end,r).emulateTransitionEnd(150):r(),this.$element.trigger("hidden.bs."+this.type),this};t.prototype.fixTitle=function(){var n=this.$element;(n.attr("title")||typeof n.attr("data-original-title")!="string")&&n.attr("data-original-title",n.attr("title")||"").attr("title","")};t.prototype.hasContent=function(){return this.getTitle()};t.prototype.getPosition=function(){var t=this.$element[0];return n.extend({},typeof t.getBoundingClientRect=="function"?t.getBoundingClientRect():{width:t.offsetWidth,height:t.offsetHeight},this.$element.offset())};t.prototype.getCalculatedOffset=function(n,t,i,r){return n=="bottom"?{top:t.top+t.height,left:t.left+t.width/2-i/2}:n=="top"?{top:t.top-r,left:t.left+t.width/2-i/2}:n=="left"?{top:t.top+t.height/2-r/2,left:t.left-i}:{top:t.top+t.height/2-r/2,left:t.left+t.width}};t.prototype.getTitle=function(){var t=this.$element,n=this.options;return t.attr("data-original-title")||(typeof n.title=="function"?n.title.call(t[0]):n.title)};t.prototype.tip=function(){return this.$tip=this.$tip||n(this.options.template)};t.prototype.arrow=function(){return this.$arrow=this.$arrow||this.tip().find(".tooltip-arrow")};t.prototype.validate=function(){this.$element[0].parentNode||(this.hide(),this.$element=null,this.options=null)};t.prototype.enable=function(){this.enabled=!0};t.prototype.disable=function(){this.enabled=!1};t.prototype.toggleEnabled=function(){this.enabled=!this.enabled};t.prototype.toggle=function(t){var i=t?n(t.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type):this;i.tip().hasClass("in")?i.leave(i):i.enter(i)};t.prototype.destroy=function(){this.hide().$element.off("."+this.type).removeData("bs."+this.type)};i=n.fn.tooltip;n.fn.tooltip=function(i){return this.each(function(){var u=n(this),r=u.data("bs.tooltip"),f=typeof i=="object"&&i;r||u.data("bs.tooltip",r=new t(this,f));typeof i=="string"&&r[i]()})};n.fn.tooltip.Constructor=t;n.fn.tooltip.noConflict=function(){return n.fn.tooltip=i,this}}(window.jQuery);+function(n){"use strict";var t=function(n,t){this.init("popover",n,t)},i;if(!n.fn.tooltip)throw new Error("Popover requires tooltip.js");t.DEFAULTS=n.extend({},n.fn.tooltip.Constructor.DEFAULTS,{placement:"right",trigger:"click",content:"",template:'<div class="popover"><div class="arrow"><\/div><h3 class="popover-title"><\/h3><div class="popover-content"><\/div><\/div>'});t.prototype=n.extend({},n.fn.tooltip.Constructor.prototype);t.prototype.constructor=t;t.prototype.getDefaults=function(){return t.DEFAULTS};t.prototype.setContent=function(){var n=this.tip(),t=this.getTitle(),i=this.getContent();n.find(".popover-title")[this.options.html?"html":"text"](t);n.find(".popover-content")[this.options.html?"html":"text"](i);n.removeClass("fade top bottom left right in");n.find(".popover-title").html()||n.find(".popover-title").hide()};t.prototype.hasContent=function(){return this.getTitle()||this.getContent()};t.prototype.getContent=function(){var t=this.$element,n=this.options;return t.attr("data-content")||(typeof n.content=="function"?n.content.call(t[0]):n.content)};t.prototype.arrow=function(){return this.$arrow=this.$arrow||this.tip().find(".arrow")};t.prototype.tip=function(){return this.$tip||(this.$tip=n(this.options.template)),this.$tip};i=n.fn.popover;n.fn.popover=function(i){return this.each(function(){var u=n(this),r=u.data("bs.popover"),f=typeof i=="object"&&i;r||u.data("bs.popover",r=new t(this,f));typeof i=="string"&&r[i]()})};n.fn.popover.Constructor=t;n.fn.popover.noConflict=function(){return n.fn.popover=i,this}}(window.jQuery);+function(n){"use strict";function t(i,r){var u,f=n.proxy(this.process,this);this.$element=n(i).is("body")?n(window):n(i);this.$body=n("body");this.$scrollElement=this.$element.on("scroll.bs.scroll-spy.data-api",f);this.options=n.extend({},t.DEFAULTS,r);this.selector=(this.options.target||(u=n(i).attr("href"))&&u.replace(/.*(?=#[^\s]+$)/,"")||"")+" .nav li > a";this.offsets=n([]);this.targets=n([]);this.activeTarget=null;this.refresh();this.process()}t.DEFAULTS={offset:10};t.prototype.refresh=function(){var i=this.$element[0]==window?"offset":"position",t,r;this.offsets=n([]);this.targets=n([]);t=this;r=this.$body.find(this.selector).map(function(){var f=n(this),r=f.data("target")||f.attr("href"),u=/^#\w/.test(r)&&n(r);return u&&u.length&&[[u[i]().top+(!n.isWindow(t.$scrollElement.get(0))&&t.$scrollElement.scrollTop()),r]]||null}).sort(function(n,t){return n[0]-t[0]}).each(function(){t.offsets.push(this[0]);t.targets.push(this[1])})};t.prototype.process=function(){var i=this.$scrollElement.scrollTop()+this.options.offset,f=this.$scrollElement[0].scrollHeight||this.$body[0].scrollHeight,e=f-this.$scrollElement.height(),t=this.offsets,r=this.targets,u=this.activeTarget,n;if(i>=e)return u!=(n=r.last()[0])&&this.activate(n);for(n=t.length;n--;)u!=r[n]&&i>=t[n]&&(!t[n+1]||i<=t[n+1])&&this.activate(r[n])};t.prototype.activate=function(t){this.activeTarget=t;n(this.selector).parents(".active").removeClass("active");var r=this.selector+'[data-target="'+t+'"],'+this.selector+'[href="'+t+'"]',i=n(r).parents("li").addClass("active");i.parent(".dropdown-menu").length&&(i=i.closest("li.dropdown").addClass("active"));i.trigger("activate")};var i=n.fn.scrollspy;n.fn.scrollspy=function(i){return this.each(function(){var u=n(this),r=u.data("bs.scrollspy"),f=typeof i=="object"&&i;r||u.data("bs.scrollspy",r=new t(this,f));typeof i=="string"&&r[i]()})};n.fn.scrollspy.Constructor=t;n.fn.scrollspy.noConflict=function(){return n.fn.scrollspy=i,this};n(window).on("load",function(){n('[data-spy="scroll"]').each(function(){var t=n(this);t.scrollspy(t.data())})})}(window.jQuery);+function(n){"use strict";var t=function(t){this.element=n(t)},i;t.prototype.show=function(){var t=this.element,e=t.closest("ul:not(.dropdown-menu)"),i=t.attr("data-target"),r,u,f;(i||(i=t.attr("href"),i=i&&i.replace(/.*(?=#[^\s]*$)/,"")),t.parent("li").hasClass("active"))||(r=e.find(".active:last a")[0],u=n.Event("show.bs.tab",{relatedTarget:r}),t.trigger(u),u.isDefaultPrevented())||(f=n(i),this.activate(t.parent("li"),e),this.activate(f,f.parent(),function(){t.trigger({type:"shown.bs.tab",relatedTarget:r})}))};t.prototype.activate=function(t,i,r){function e(){u.removeClass("active").find("> .dropdown-menu > .active").removeClass("active");t.addClass("active");f?(t[0].offsetWidth,t.addClass("in")):t.removeClass("fade");t.parent(".dropdown-menu")&&t.closest("li.dropdown").addClass("active");r&&r()}var u=i.find("> .active"),f=r&&n.support.transition&&u.hasClass("fade");f?u.one(n.support.transition.end,e).emulateTransitionEnd(150):e();u.removeClass("in")};i=n.fn.tab;n.fn.tab=function(i){return this.each(function(){var u=n(this),r=u.data("bs.tab");r||u.data("bs.tab",r=new t(this));typeof i=="string"&&r[i]()})};n.fn.tab.Constructor=t;n.fn.tab.noConflict=function(){return n.fn.tab=i,this};n(document).on("click.bs.tab.data-api",'[data-toggle="tab"], [data-toggle="pill"]',function(t){t.preventDefault();n(this).tab("show")})}(window.jQuery);+function(n){"use strict";var t=function(i,r){this.options=n.extend({},t.DEFAULTS,r);this.$window=n(window).on("scroll.bs.affix.data-api",n.proxy(this.checkPosition,this)).on("click.bs.affix.data-api",n.proxy(this.checkPositionWithEventLoop,this));this.$element=n(i);this.affixed=this.unpin=null;this.checkPosition()},i;t.RESET="affix affix-top affix-bottom";t.DEFAULTS={offset:0};t.prototype.checkPositionWithEventLoop=function(){setTimeout(n.proxy(this.checkPosition,this),1)};t.prototype.checkPosition=function(){var i;if(this.$element.is(":visible")){var s=n(document).height(),e=this.$window.scrollTop(),o=this.$element.offset(),r=this.options.offset,f=r.top,u=r.bottom;(typeof r!="object"&&(u=f=r),typeof f=="function"&&(f=r.top()),typeof u=="function"&&(u=r.bottom()),i=this.unpin!=null&&e+this.unpin<=o.top?!1:u!=null&&o.top+this.$element.height()>=s-u?"bottom":f!=null&&e<=f?"top":!1,this.affixed!==i)&&(this.unpin&&this.$element.css("top",""),this.affixed=i,this.unpin=i=="bottom"?o.top-e:null,this.$element.removeClass(t.RESET).addClass("affix"+(i?"-"+i:"")),i=="bottom"&&this.$element.offset({top:document.body.offsetHeight-u-this.$element.height()}))}};i=n.fn.affix;n.fn.affix=function(i){return this.each(function(){var u=n(this),r=u.data("bs.affix"),f=typeof i=="object"&&i;r||u.data("bs.affix",r=new t(this,f));typeof i=="string"&&r[i]()})};n.fn.affix.Constructor=t;n.fn.affix.noConflict=function(){return n.fn.affix=i,this};n(window).on("load",function(){n('[data-spy="affix"]').each(function(){var i=n(this),t=i.data();t.offset=t.offset||{};t.offsetBottom&&(t.offset.bottom=t.offsetBottom);t.offsetTop&&(t.offset.top=t.offsetTop);i.affix(t)})})}(window.jQuery);$(window).one('load',function(){WWP_VV([['Bootstrap.DVProgressIndicator','1.1'],['Bootstrap.Panel','1.2'],['Bootstrap.SidebarMenu','15.2.9'],['Bootstrap.TabsPanel','1.2'],['Bootstrap.ConfirmPanel','15.1.4'],['Bootstrap.TagsInput','15.0.1'],['Bootstrap.DropDownOptions','14.0']]);});