﻿function DVelop_DVMessage(n){this.Width;this.MinHeight;this.StylingType;this.DefaultMessageType;this.TitleEscape;this.TextEscape;this.ChangeNewLinesToBRs;this.Hide;this.DelayUntilHide;this.MouseHideReset;this.MessageAdditionalClasses;this.StackVerticalSpacing;this.StackHorizontalSpacing;this.StackVerticalFirstPos;this.StackHorizontalFirstPos;this.MessageCornerClass;this.Shadow;this.Opacity;this.EffectIn;this.EffectOut;this.AnimationSpeed;this.StartPosition;this.NextMessagePosition;this.Closer;this.CloserHover;this.Sticker;this.StickerHover;this.LabelCloseButton;this.LabelStickButton;this.showEvenOnNonblock;this.NonBlock;this.NonBlockOpacity;this.EnableHistory;this.Menu;this.FixedMenu;this.MaxOnScreen;this.LabelRedisplay;this.LabelAll;this.LabelLast;this.StopOnError;var t=n("body").css("direction")==="rtl";this.show=function(){var t,i,r;gx.fx.obs.addObserver("gx.onmessages",this,this.showMessages);window!=top&&top.PNotify!=null&&(PNotify=top.PNotify);t=jQuery("#gxErrorViewer").children();t.length==0&&(t=jQuery('[data-gx-id="gxErrorViewer"]').children());t.length==0&&(t=jQuery(".ErrorViewer.gx_ev[data-gx-id]").children());i=[];jQuery.each(t,function(t,r){i.push({att:"",type:n(r).hasClass("gx-error-message")?1:0,text:jQuery(r).html()})});i.length>0&&(r={},r.MAIN=i,this.showMessages(r));gx.evt.on_ready(this,this.removeErrorViewers)};this.removeErrorViewers=function(){jQuery("[id*=gxErrorViewer]").remove()};this.showMessages=function(n){this._options=this.dvGetPinesNotifyDefaultsFromGXUC();for(var t in n)t!=undefined&&this.dvRenderPNotify(n[t])};this.dvRenderPNotify=function(i){var u=this,o=i,r,f,e;i.msgs&&(o=i.msgs);r=jQuery.extend({},PNotify.prototype.options,u._options);r.stack.dir1=u.NextMessagePosition;this.StartPosition.indexOf("Top")>=0&&r.stack.dir1=="up"?r.stack.dir1="down":this.StartPosition.indexOf("Bottom")>=0&&r.stack.dir1=="down"&&(r.stack.dir1="up");f="";e=this.StartPosition;t&&(e=e.indexOf("Left")>0?e.replace("Left","Right"):e.replace("Right","Left"));switch(e){case"TopCenter":f="stack-topcenter";r.stack.push="top";break;case"TopLeft":f="stack-topleft";r.stack.dir2="right";r.stack.push="top";break;case"TopRight":f="stack-topright";r.stack.dir2="left";r.stack.push="top";break;case"BottomRight":f="stack-bottomright";r.stack.dir2="left";r.stack.push="bottom";break;case"BottomCenter":f="stack-bottomcenter";r.stack.push="bottom";break;case"BottomLeft":f="stack-bottomleft";r.stack.dir2="right";r.stack.push="bottom";break;case"DialogCenter":f="stack-center";r.stack.push="top";r.stack.dir1="down"}r.stack.firstpos1=u.StackVerticalFirstPos;r.stack.firstpos2=u.StackHorizontalFirstPos;r.stack.spacing1=u.StackVerticalSpacing;r.stack.spacing2=u.StackHorizontalSpacing;r.addclass=f+" "+u.MessageAdditionalClasses;PNotify.prototype.options.addclass=r.addclass;r.history.history=u.EnableHistory;r.history.menu=u.Menu;r.history.fixed=u.FixedMenu;r.history.maxonscreen=u.MaxOnScreen;r.history.labels.redisplay=u.LabelRedisplay;r.history.labels.all=u.LabelAll;r.history.labels.last=u.LabelLast;this.focusMade=n(document.activeElement).is(".form-control.Errorform-control,button.Errorbtn-default");jQuery.each(o,function(t,i){var o,r,e,s,f,h;if(i&&i.text){if(o=i.text.substr(0,1)=="{"?!0:!1,r=null,o&&(f=u.dvGetMessageParms(i.text),f&&f.att!=""&&(r=jQuery(f.att).get(0)),i.att&&i.att!=""&&(i.att="")),e=!1,r==null)if(i.att&&i.att!=""){if(jQuery("#"+i.att+"_Balloon").remove(),r=jQuery("#"+i.att).get(0),r==null&&(s=i.att,n(".ExtendedComboCell>div").each(function(){this.id!=null&&WWP_startsWith(this.id,"W0")&&WWP_endsWith(this.id,s)&&(r=n("#"+this.id.replace("TABLESPLITTED","")))})),r==null)try{r=gx.fn.screen_CtrlRef(i.att);e=r!=null;e&&jQuery("#"+n(r).attr("id")+"_Balloon").remove()}catch(c){}}else f=u.dvGetMessageParms(i.text),f&&f.att!=""&&(r=jQuery(f.att).get(0));r&&i.text!=""?u.dvSendMessageToGX(o,r,i,e):u.dvSendMessageToPNotify(i.text);h=gx.dom.byClass("gx_ev","span");n(h).remove()}})};this.dvSendMessageToGX=function(t,i,r,u){var h=this,c=null,l=jQuery("#span_"+i.id).get(0),o=r.text,f=jQuery(i),s,e;t&&(c=h.dvGetMessageParms(r.text),o=c.text);s=!1;f.is(":visible")||(e=(u?"#DVC_"+f.attr("id")+"_btnGroupDrop":"#COMBO_"+f.attr("id")+"Container_btnGroupDrop")+", "+(u?"#DVC_"+f.attr("id")+"_inputSuggest":"#COMBO_"+f.attr("id")+"Container_inputSuggest"),n(e).length>=1?(f=n(e).last(),i=f.get(0),s=!0):r!=null&&r.att!=null&&r.att!=f.attr("id")&&(e="#"+f.attr("id").replace(r.att,"")+(u?"DVC_"+f.attr("id")+"_btnGroupDrop":"COMBO_"+r.att+"Container_btnGroupDrop")+", #"+f.attr("id").replace(r.att,"")+(u?"DVC_"+f.attr("id")+"_inputSuggest":"COMBO_"+r.att+"Container_inputSuggest"),n(e).length>=1&&(f=n(e).last(),i=f.get(0),s=!0)));f.is(":visible")?t||s?(gx.fn.alert(i,o),this.focusMade||this.StopOnError!=!0||this.focusOnAtt(i)):this.focusMade||this.StopOnError!=!0||this.focusOnAtt(i):l?gx.fn.alert(l,o):h.dvSendMessageToPNotify(o)};this.focusOnAtt=function(t){var i,r;this.focusMade=!0;i=n(t).data("daterangepicker");i!=null&&(i.focusingOnError=!0);r=n(document.activeElement).data("daterangepicker");r!=null&&r.hide!=null&&r.hide();t.focus();i!=null&&i.focusingOnError!=null&&delete i.focusingOnError};this.dvSendMessageToPNotify=function(n){var r,u;if(n=="<#CLEAR#>"||n=="&lt;#CLEAR#&gt;"){PNotify.removeAll();return}r=this;u=r.dvGetMessageParms(n);u||(u={text:n});var f=jQuery.extend({},PNotify.prototype.options,r._options),t=jQuery.extend({},f,u),i=null;t.desktop&&t.desktop.desktop?(PNotify.desktop.permission(),i=new PNotify({title:t.title,text:t.text,styling:t.styling,desktop:{desktop:!0,fallback:t.fallback}}),r.attachNotifClick(i,t.clickUrl)):window.parent&&window.parent.PNotify?window.parent.$(function(){t.stack.context&&delete t.stack.context;i=new window.parent.PNotify(t);r.attachNotifClick(i,t.clickUrl)}):(i=new PNotify(t),this.attachNotifClick(i,t.clickUrl))};this.attachNotifClick=function(t,i){t.get().click(function(t){n(".ui-pnotify-closer, .ui-pnotify-sticker, .ui-pnotify-closer *, .ui-pnotify-sticker *").is(t.target)||i!=null&&i!=""&&(window.location.href=i)})};this.dvGetPinesNotifyDefaultsFromGXUC=function(){var n=this.Width.replace("px","");return this.Width=isNaN(n)?"300px":n+"px",n=this.MinHeight.replace("px",""),this.MinHeight=isNaN(n)?"16px":n+"px",{title_escape:this.TitleEscape,text_escape:this.TextEscape,insert_brs:this.ChangeNewLinesToBRs,styling:this.StylingType,type:this.DefaultMessageType,width:this.Width,min_height:this.MinHeight,hide:this.Hide,delay:this.DelayUntilHide,mouse_reset:this.MouseHideReset,cornerclass:this.MessageCornerClass,shadow:this.Shadow,opacity:this.Opacity,animation:{effect_in:this.EffectIn,effect_out:this.EffectOut},animate_speed:this.AnimationSpeed,buttons:{closer:this.Closer,closer_hover:this.CloserHover,sticker:this.Sticker,sticker_hover:this.StickerHover,show_on_nonblock:this.showEvenOnNonblock,labels:{close:this.LabelCloseButton,stick:this.LabelStickButton}},nonblock:{nonblock:this.NonBlock,nonblock_opacity:this.NonBlockOpacity},history:{history:this.EnableHistory,menu:this.Menu,fixed:this.FixedMenu,maxonscreen:this.MaxOnScreen,labels:{redisplay:this.LabelRedisplay,all:this.LabelAll,last:this.LabelLast}}}};this.dvGetMessageParms=function(n){var i=null,r={},t="";try{n.substring(0,1)=="{"&&(t=WWP_replaceAll(n,"\r\n","<br>"),t=WWP_replaceAll(t,"\n","<br>"),r=eval("("+t+")"),i=jQuery.extend({},this._options,r))}catch(u){window.console&&console.log(u.message)}return i}};$(window).one('load',function(){WWP_VV([['DVMessage','15.2.1']]);});