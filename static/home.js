gx.evt.autoSkip=!1;gx.define("home",!1,function(){var t,n;this.ServerClass="home";this.PackageName="com";this.ServerFullClass="com.home";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV6HomeModulesSDT=gx.fn.getControlValue("vHOMEMODULESSDT");this.subGridhomemodulessdts_Recordcount=gx.fn.getIntegerValue("subGridhomemodulessdts_Recordcount",".")};this.e13072_client=function(){return this.clearMessages(),gx.text.compare("",this.AV5OptionLink)==0||this.callUrl(this.AV5OptionLink),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14072_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e15072_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19,20,21,22,23,24,25];this.GXLastCtrlId=25;this.GridhomemodulessdtsContainer=new gx.grid.grid(this,2,"WbpLvl2",12,"Gridhomemodulessdts","Gridhomemodulessdts","GridhomemodulessdtsContainer",this.CmpContext,this.IsMasterPage,"home",[],!0,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px","Nueva fila",!1,!1,!1,gx.grid.flexGrid,null,!1,"",!0,[2,3,3,3],!1,0,!1,!1);n=this.GridhomemodulessdtsContainer;n.startDiv(13,"Mainlayout","0px","0px");n.startDiv(14,"","0px","0px");n.startDiv(15,"Homemodulesbig_tablemodule","0px","0px");n.startDiv(16,"","0px","0px");n.addTextBlock("HOMEMODULESBIG_OPTIONICON",null,17);n.endDiv();n.startDiv(18,"","0px","0px");n.addTextBlock("HOMEMODULESBIG_TITLE",null,19);n.endDiv();n.startDiv(20,"","0px","0px");n.addTextBlock("HOMEMODULESBIG_DESCRIPTION",null,21);n.endDiv();n.endDiv();n.endDiv();n.startDiv(22,"","0px","0px");n.startDiv(23,"","0px","0px");n.startDiv(24,"","0px","75%");n.addMultipleLineEdit("Optionlink",25,"vOPTIONLINK","","OptionLink","svchar",80,"chr",3,"row","200",200,"start",null,!0,!1,0,"");n.endDiv();n.endDiv();n.endDiv();n.endDiv();this.GridhomemodulessdtsContainer.emptyText="";n.setRenderProp("Class","Class","FreeStyleHomeModulesBig","str");n.setRenderProp("Enabled","Enabled",!0,"boolean");n.setRenderProp("FlexDirection","Flexdirection","row","str");n.setRenderProp("FlexWrap","Flexwrap","wrap","str");n.setRenderProp("JustifyContent","Justifycontent","center","str");n.setRenderProp("AlignItems","Alignitems","stretch","str");n.setRenderProp("AlignContent","Aligncontent","stretch","str");n.setRenderProp("Visible","Visible",!0,"boolean");this.setGrid(n);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLECONTENT",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[13]={id:13,fld:"MAINLAYOUT",grid:12,evt:"e13072_client"};t[14]={id:14,fld:"",grid:12};t[15]={id:15,fld:"HOMEMODULESBIG_TABLEMODULE",grid:12};t[16]={id:16,fld:"",grid:12};t[17]={id:17,fld:"HOMEMODULESBIG_OPTIONICON",format:2,grid:12,ctrltype:"textblock"};t[18]={id:18,fld:"",grid:12};t[19]={id:19,fld:"HOMEMODULESBIG_TITLE",format:0,grid:12,ctrltype:"textblock"};t[20]={id:20,fld:"",grid:12};t[21]={id:21,fld:"HOMEMODULESBIG_DESCRIPTION",format:0,grid:12,ctrltype:"textblock"};t[22]={id:22,fld:"",grid:12};t[23]={id:23,fld:"",grid:12};t[24]={id:24,fld:"",grid:12};t[25]={id:25,lvl:2,type:"svchar",len:200,dec:0,sign:!1,ro:1,isacc:0,multiline:!0,grid:12,gxgrid:this.GridhomemodulessdtsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vOPTIONLINK",fmt:0,gxz:"ZV5OptionLink",gxold:"OV5OptionLink",gxvar:"AV5OptionLink",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV5OptionLink=n)},v2z:function(n){n!==undefined&&(gx.O.ZV5OptionLink=n)},v2c:function(n){gx.fn.setGridControlValue("vOPTIONLINK",n||gx.fn.currentGridRowImpl(12),gx.O.AV5OptionLink,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV5OptionLink=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vOPTIONLINK",n||gx.fn.currentGridRowImpl(12))},nac:gx.falseFn};this.AV5OptionLink="";this.AV6HomeModulesSDT=[];this.Events={e14072_client:["ENTER",!0],e15072_client:["CANCEL",!0],e13072_client:["MAINLAYOUT.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRIDHOMEMODULESSDTS_nFirstRecordOnPage"},{av:"GRIDHOMEMODULESSDTS_nEOF"},{av:"AV6HomeModulesSDT",fld:"vHOMEMODULESSDT",pic:"",hsh:!0}],[]];this.EvtParms["GRIDHOMEMODULESSDTS.LOAD"]=[[{av:"AV6HomeModulesSDT",fld:"vHOMEMODULESSDT",pic:"",hsh:!0}],[{av:'gx.fn.getCtrlProperty("HOMEMODULESBIG_OPTIONICON","Caption")',ctrl:"HOMEMODULESBIG_OPTIONICON",prop:"Caption"},{av:'gx.fn.getCtrlProperty("HOMEMODULESBIG_TITLE","Caption")',ctrl:"HOMEMODULESBIG_TITLE",prop:"Caption"},{av:'gx.fn.getCtrlProperty("HOMEMODULESBIG_DESCRIPTION","Caption")',ctrl:"HOMEMODULESBIG_DESCRIPTION",prop:"Caption"},{av:"AV5OptionLink",fld:"vOPTIONLINK",pic:"",hsh:!0}]];this.EvtParms["MAINLAYOUT.CLICK"]=[[{av:"AV5OptionLink",fld:"vOPTIONLINK",pic:"",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV6HomeModulesSDT","vHOMEMODULESSDT",0,"CollWWPBaseObjectsHomeModulesSDT.HomeModulesSDTItem",0,0);this.setVCMap("AV6HomeModulesSDT","vHOMEMODULESSDT",0,"CollWWPBaseObjectsHomeModulesSDT.HomeModulesSDTItem",0,0);this.setVCMap("AV6HomeModulesSDT","vHOMEMODULESSDT",0,"CollWWPBaseObjectsHomeModulesSDT.HomeModulesSDTItem",0,0);n.addRefreshingVar({rfrVar:"AV6HomeModulesSDT"});n.addRefreshingParm({rfrVar:"AV6HomeModulesSDT"});this.Initialize()});gx.wi(function(){gx.createParentObj(this.home)})