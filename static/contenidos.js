gx.evt.autoSkip=!1;gx.define("contenidos",!1,function(){this.ServerClass="contenidos";this.PackageName="com";this.ServerFullClass="com.contenidos";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CntdID=gx.fn.getIntegerValue("vCNTDID",".");this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV9TrnContext=gx.fn.getControlValue("vTRNCONTEXT")};this.Valid_Cntdid=function(){return this.validCliEvt("Valid_Cntdid",0,function(){try{var n=gx.util.balloon.getNew("CNTDID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e12042_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e13044_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e14044_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33];this.GXLastCtrlId=33;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLEATTRIBUTES",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,lvl:0,type:"char",len:60,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CNTDDESC",fmt:0,gxz:"Z24CntdDesc",gxold:"O24CntdDesc",gxvar:"A24CntdDesc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A24CntdDesc=n)},v2z:function(n){n!==undefined&&(gx.O.Z24CntdDesc=n)},v2c:function(){gx.fn.setControlValue("CNTDDESC",gx.O.A24CntdDesc,0)},c2v:function(){this.val()!==undefined&&(gx.O.A24CntdDesc=this.val())},val:function(){return gx.fn.getControlValue("CNTDDESC")},nac:gx.falseFn};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"BTNTRN_ENTER",grid:0,evt:"e13044_client",std:"ENTER"};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"BTNTRN_CANCEL",grid:0,evt:"e14044_client"};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"BTNTRN_DELETE",grid:0,evt:"e15044_client",std:"DELETE"};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[33]={id:33,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Cntdid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CNTDID",fmt:0,gxz:"Z23CntdID",gxold:"O23CntdID",gxvar:"A23CntdID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A23CntdID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z23CntdID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CNTDID",gx.O.A23CntdID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A23CntdID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CNTDID",".")},nac:gx.falseFn};this.declareDomainHdlr(33,function(){});this.A24CntdDesc="";this.Z24CntdDesc="";this.O24CntdDesc="";this.A23CntdID=0;this.Z23CntdID=0;this.O23CntdID=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CntdID=0;this.AV10WebSession={};this.A23CntdID=0;this.A24CntdDesc="";this.Gx_mode="";this.Events={e12042_client:["AFTER TRN",!0],e13044_client:["ENTER",!0],e14044_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CntdID",fld:"vCNTDID",pic:"ZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV9TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0},{av:"AV7CntdID",fld:"vCNTDID",pic:"ZZZZZZZZZ9",hsh:!0},{av:"A23CntdID",fld:"CNTDID",pic:"ZZZZZZZZZ9"}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV9TrnContext",fld:"vTRNCONTEXT",pic:"",hsh:!0}],[]];this.EvtParms.VALID_CNTDID=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CntdID","vCNTDID",0,"int",10,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV9TrnContext","vTRNCONTEXT",0,"WWPBaseObjectsWWPTransactionContext",0,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.contenidos)})