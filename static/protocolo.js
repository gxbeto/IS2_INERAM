gx.evt.autoSkip=!1;gx.define("protocolo",!1,function(){var n,i,r,u,t;this.ServerClass="protocolo";this.PackageName="com";this.ServerFullClass="com.protocolo";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7ProtID=gx.fn.getIntegerValue("vPROTID",".");this.AV11Insert_EnfID=gx.fn.getIntegerValue("vINSERT_ENFID",".");this.AV12Insert_CntdID=gx.fn.getIntegerValue("vINSERT_CNTDID",".");this.A3EnfDesc=gx.fn.getControlValue("ENFDESC");this.A24CntdDesc=gx.fn.getControlValue("CNTDDESC");this.AV24Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV22DetailWCInfo=gx.fn.getControlValue("vDETAILWCINFO");this.AV23CurrentTab_ReturnUrl=gx.fn.getControlValue("vCURRENTTAB_RETURNURL")};this.Valid_Protid=function(){return this.validCliEvt("Valid_Protid",0,function(){try{var n=gx.util.balloon.getNew("PROTID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Enfid=function(){return this.validSrvEvt("valid_Enfid",0).then(function(n){return n}.closure(this))};this.Valid_Cntdid=function(){return this.validSrvEvt("valid_Cntdid",0).then(function(n){return n}.closure(this))};this.Validv_Comboenfid=function(){return this.validCliEvt("Validv_Comboenfid",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOENFID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_Combocntdid=function(){return this.validCliEvt("Validv_Combocntdid",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOCNTDID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11055_client=function(){return this.clearMessages(),this.WWPUTILITIESContainer.CurrentTab_Return(),this.AV23CurrentTab_ReturnUrl=this.WWPUTILITIESContainer.CurrentTab_ReturnUrl,gx.text.compare("",this.AV23CurrentTab_ReturnUrl)==0||this.callUrl(this.AV23CurrentTab_ReturnUrl),gx.text.compare(this.Gx_mode,"INS")==0&&gx.fx.obs.notify("SplitScreenWithTabs_UpdateTab",[6,this.AV22DetailWCInfo,!1,"protocolo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14055_client=function(){return this.clearMessages(),this.AV21ComboCntdID=gx.num.trunc(gx.num.val(this.COMBO_CNTDIDContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV21ComboCntdID",fld:"vCOMBOCNTDID",pic:"ZZZZZZZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15055_client=function(){return this.clearMessages(),this.AV19ComboEnfID=gx.num.trunc(gx.num.val(this.COMBO_ENFIDContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV19ComboEnfID",fld:"vCOMBOENFID",pic:"ZZZZZZZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e13052_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e16055_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17055_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70];this.GXLastCtrlId=70;this.COMBO_ENFIDContainer=gx.uc.getNew(this,30,22,"BootstrapDropDownOptions","COMBO_ENFIDContainer","Combo_enfid","COMBO_ENFID");i=this.COMBO_ENFIDContainer;i.setProp("Class","Class","","char");i.setProp("IconType","Icontype","Image","str");i.setProp("Icon","Icon","","str");i.setProp("Caption","Caption","","str");i.setProp("Tooltip","Tooltip","","str");i.setProp("Cls","Cls","ExtendedCombo Attribute","str");i.setDynProp("SelectedValue_set","Selectedvalue_set","","char");i.setProp("SelectedValue_get","Selectedvalue_get","","char");i.setDynProp("SelectedText_set","Selectedtext_set","","char");i.setProp("SelectedText_get","Selectedtext_get","","char");i.setProp("GAMOAuthToken","Gamoauthtoken","","char");i.setProp("DDOInternalName","Ddointernalname","","char");i.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");i.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");i.setDynProp("Enabled","Enabled",!0,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");i.setProp("DataListType","Datalisttype","Dynamic","str");i.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");i.setProp("DataListFixedValues","Datalistfixedvalues","","char");i.setProp("IsGridItem","Isgriditem",!1,"bool");i.setProp("HasDescription","Hasdescription",!1,"bool");i.setProp("DataListProc","Datalistproc","ProtocoloLoadDVCombo","str");i.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "EnfID", "TrnMode": "INS", "IsDynamicCall": true, "ProtID": 0',"str");i.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");i.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");i.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");i.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");i.setProp("EmptyItem","Emptyitem",!0,"bool");i.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");i.setProp("HTMLTemplate","Htmltemplate","","str");i.setProp("MultipleValuesType","Multiplevaluestype","Text","str");i.setProp("LoadingData","Loadingdata","","str");i.setProp("NoResultsFound","Noresultsfound","","str");i.setProp("EmptyItemText","Emptyitemtext","GX_EmptyItemText","str");i.setProp("OnlySelectedValues","Onlyselectedvalues","","char");i.setProp("SelectAllText","Selectalltext","","char");i.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");i.setProp("AddNewOptionText","Addnewoptiontext","","str");i.addV2CFunction("AV15DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");i.addC2VFunction(function(n){n.ParentObject.AV15DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV15DDO_TitleSettingsIcons)});i.addV2CFunction("AV14EnfID_Data","vENFID_DATA","SetDropDownOptionsData");i.addC2VFunction(function(n){n.ParentObject.AV14EnfID_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vENFID_DATA",n.ParentObject.AV14EnfID_Data)});i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("OnOptionClicked",this.e15055_client);this.setUserControl(i);this.COMBO_CNTDIDContainer=gx.uc.getNew(this,41,22,"BootstrapDropDownOptions","COMBO_CNTDIDContainer","Combo_cntdid","COMBO_CNTDID");r=this.COMBO_CNTDIDContainer;r.setProp("Class","Class","","char");r.setProp("IconType","Icontype","Image","str");r.setProp("Icon","Icon","","str");r.setProp("Caption","Caption","","str");r.setProp("Tooltip","Tooltip","","str");r.setProp("Cls","Cls","ExtendedCombo Attribute","str");r.setDynProp("SelectedValue_set","Selectedvalue_set","","char");r.setProp("SelectedValue_get","Selectedvalue_get","","char");r.setDynProp("SelectedText_set","Selectedtext_set","","char");r.setProp("SelectedText_get","Selectedtext_get","","char");r.setProp("GAMOAuthToken","Gamoauthtoken","","char");r.setProp("DDOInternalName","Ddointernalname","","char");r.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");r.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");r.setDynProp("Enabled","Enabled",!0,"bool");r.setProp("Visible","Visible",!0,"bool");r.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");r.setProp("DataListType","Datalisttype","Dynamic","str");r.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");r.setProp("DataListFixedValues","Datalistfixedvalues","","char");r.setProp("IsGridItem","Isgriditem",!1,"bool");r.setProp("HasDescription","Hasdescription",!1,"bool");r.setProp("DataListProc","Datalistproc","ProtocoloLoadDVCombo","str");r.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "CntdID", "TrnMode": "INS", "IsDynamicCall": true, "ProtID": 0',"str");r.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");r.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");r.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");r.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");r.setProp("EmptyItem","Emptyitem",!0,"bool");r.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");r.setProp("HTMLTemplate","Htmltemplate","","str");r.setProp("MultipleValuesType","Multiplevaluestype","Text","str");r.setProp("LoadingData","Loadingdata","","str");r.setProp("NoResultsFound","Noresultsfound","","str");r.setProp("EmptyItemText","Emptyitemtext","GX_EmptyItemText","str");r.setProp("OnlySelectedValues","Onlyselectedvalues","","char");r.setProp("SelectAllText","Selectalltext","","char");r.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");r.setProp("AddNewOptionText","Addnewoptiontext","","str");r.addV2CFunction("AV15DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");r.addC2VFunction(function(n){n.ParentObject.AV15DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV15DDO_TitleSettingsIcons)});r.addV2CFunction("AV20CntdID_Data","vCNTDID_DATA","SetDropDownOptionsData");r.addC2VFunction(function(n){n.ParentObject.AV20CntdID_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vCNTDID_DATA",n.ParentObject.AV20CntdID_Data)});r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});r.addEventHandler("OnOptionClicked",this.e14055_client);this.setUserControl(r);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");u=this.DVPANEL_TABLEATTRIBUTESContainer;u.setProp("Class","Class","","char");u.setProp("Enabled","Enabled",!0,"boolean");u.setProp("Width","Width","100%","str");u.setProp("Height","Height","100","str");u.setProp("AutoWidth","Autowidth",!1,"bool");u.setProp("AutoHeight","Autoheight",!0,"bool");u.setProp("Cls","Cls","PanelCard_GrayTitle","str");u.setProp("ShowHeader","Showheader",!0,"bool");u.setProp("Title","Title","Información General","str");u.setProp("Collapsible","Collapsible",!1,"bool");u.setProp("Collapsed","Collapsed",!1,"bool");u.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");u.setProp("IconPosition","Iconposition","Right","str");u.setProp("AutoScroll","Autoscroll",!1,"bool");u.setProp("Visible","Visible",!0,"bool");u.setProp("Gx Control Type","Gxcontroltype","","int");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);this.WWPUTILITIESContainer=gx.uc.getNew(this,71,22,"DVelop_WorkWithPlusUtilities","WWPUTILITIESContainer","Wwputilities","WWPUTILITIES");t=this.WWPUTILITIESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("EnableAutoUpdateFromDocumentTitle","Enableautoupdatefromdocumenttitle",!1,"bool");t.setProp("EnableFixObjectFitCover","Enablefixobjectfitcover",!1,"bool");t.setProp("EnableFloatingLabels","Enablefloatinglabels",!1,"bool");t.setProp("EmpowerTabs","Empowertabs",!1,"bool");t.setProp("EnableUpdateRowSelectionStatus","Enableupdaterowselectionstatus",!1,"bool");t.setProp("CurrentTab_ReturnUrl","Currenttab_returnurl","","char");t.setProp("EnableConvertComboToBootstrapSelect","Enableconvertcombotobootstrapselect",!1,"bool");t.setProp("AllowColumnResizing","Allowcolumnresizing",!1,"bool");t.setProp("AllowColumnReordering","Allowcolumnreordering",!1,"bool");t.setProp("AllowColumnDragging","Allowcolumndragging",!1,"bool");t.setProp("AllowColumnsRestore","Allowcolumnsrestore",!1,"bool");t.setProp("RestoreColumnsIconClass","Restorecolumnsiconclass","fas fa-undo","str");t.setProp("PagBarIncludeGoTo","Pagbarincludegoto",!1,"bool");t.setProp("ComboLoadType","Comboloadtype","All","str");t.setProp("InfiniteScrollingPage","Infinitescrollingpage",10,"num");t.setProp("UpdateButtonText","Updatebuttontext","WWP_ColumnsSelectorButton","str");t.setProp("AddNewOption","Addnewoption","WWP_AddNewOption","str");t.setProp("OnlySelectedValues","Onlyselectedvalues","WWP_OnlySelectedValues","str");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator",", ","str");t.setProp("SelectAll","Selectall","WWP_SelectAll","str");t.setProp("SortASC","Sortasc","WWP_TSSortASC","str");t.setProp("SortDSC","Sortdsc","WWP_TSSortDSC","str");t.setProp("AllowGroupText","Allowgrouptext","WWP_GroupByOption","str");t.setProp("FixLeftText","Fixlefttext","WWP_TSFixLeft","str");t.setProp("FixRightText","Fixrighttext","WWP_TSFixRight","str");t.setProp("LoadingData","Loadingdata","WWP_TSLoading","str");t.setProp("CleanFilter","Cleanfilter","WWP_TSCleanFilter","str");t.setProp("RangeFilterFrom","Rangefilterfrom","WWP_TSFrom","str");t.setProp("RangeFilterTo","Rangefilterto","WWP_TSTo","str");t.setProp("RangePickerInviteMessage","Rangepickerinvitemessage","WWP_TSRangePickerInviteMessage","str");t.setProp("NoResultsFound","Noresultsfound","WWP_TSNoResults","str");t.setProp("SearchButtonText","Searchbuttontext","WWP_TSSearchButtonCaption","str");t.setProp("SearchMultipleValuesButtonText","Searchmultiplevaluesbuttontext","WWP_FilterSelected","str");t.setProp("ColumnSelectorFixedLeftCategory","Columnselectorfixedleftcategory","WWP_ColumnSelectorFixedLeftCategory","str");t.setProp("ColumnSelectorFixedRightCategory","Columnselectorfixedrightcategory","WWP_ColumnSelectorFixedRightCategory","str");t.setProp("ColumnSelectorNotFixedCategory","Columnselectornotfixedcategory","WWP_ColumnSelectorNotFixedCategory","str");t.setProp("ColumnSelectorNoCategoryText","Columnselectornocategorytext","WWP_ColumnSelectorNoCategoryText","str");t.setProp("ColumnSelectorFixedEmpty","Columnselectorfixedempty","WWP_ColumnSelectorFixedEmpty","str");t.setProp("ColumnSelectorRestoreTooltip","Columnselectorrestoretooltip","WWP_SelectColumns_RestoreDefault","str");t.setProp("PagBarGoToCaption","Pagbargotocaption","WWP_PaginationBarGoToCaption","str");t.setProp("PagBarGoToIconClass","Pagbargotoiconclass","fas fa-redo","str");t.setProp("PagBarGoToTooltip","Pagbargototooltip","WWP_PaginationBarGoToTooltip","str");t.setProp("PagBarEmptyFilteredGridCaption","Pagbaremptyfilteredgridcaption","WWP_PaginationBarEmptyFilteredGridCaption","str");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLECONTENT",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Protid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PROTID",fmt:0,gxz:"Z25ProtID",gxold:"O25ProtID",gxvar:"A25ProtID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A25ProtID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z25ProtID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PROTID",gx.O.A25ProtID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A25ProtID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PROTID",".")},nac:gx.falseFn};this.declareDomainHdlr(22,function(){});n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"TABLESPLITTEDENFID",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"TEXTBLOCKENFID",format:0,grid:0,ctrltype:"textblock"};n[29]={id:29,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Enfid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ENFID",fmt:0,gxz:"Z1EnfID",gxold:"O1EnfID",gxvar:"A1EnfID",ucs:[],op:[],ip:[33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EnfID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EnfID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("ENFID",gx.O.A1EnfID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EnfID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("ENFID",".")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV11Insert_EnfID)}};this.declareDomainHdlr(33,function(){});n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"TABLESPLITTEDCNTDID",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"TEXTBLOCKCNTDID",format:0,grid:0,ctrltype:"textblock"};n[40]={id:40,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Cntdid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CNTDID",fmt:0,gxz:"Z23CntdID",gxold:"O23CntdID",gxvar:"A23CntdID",ucs:[],op:[],ip:[44],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A23CntdID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z23CntdID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CNTDID",gx.O.A23CntdID,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A23CntdID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CNTDID",".")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV12Insert_CntdID)}};this.declareDomainHdlr(44,function(){});n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PROTORD",fmt:0,gxz:"Z26ProtOrd",gxold:"O26ProtOrd",gxvar:"A26ProtOrd",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A26ProtOrd=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z26ProtOrd=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PROTORD",gx.O.A26ProtOrd,0)},c2v:function(){this.val()!==undefined&&(gx.O.A26ProtOrd=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PROTORD",".")},nac:gx.falseFn};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"",grid:0};n[54]={id:54,lvl:0,type:"svchar",len:10240,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PROTTXT",fmt:0,gxz:"Z27ProtTxt",gxold:"O27ProtTxt",gxvar:"A27ProtTxt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A27ProtTxt=n)},v2z:function(n){n!==undefined&&(gx.O.Z27ProtTxt=n)},v2c:function(){gx.fn.setControlValue("PROTTXT",gx.O.A27ProtTxt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A27ProtTxt=this.val())},val:function(){return gx.fn.getControlValue("PROTTXT")},nac:gx.falseFn};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"BTNTRN_ENTER",grid:0,evt:"e16055_client",std:"ENTER"};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"BTNTRN_CANCEL",grid:0,evt:"e11055_client"};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"BTNTRN_DELETE",grid:0,evt:"e18055_client",std:"DELETE"};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[67]={id:67,fld:"SECTIONATTRIBUTE_ENFID",grid:0};n[68]={id:68,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Comboenfid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOENFID",fmt:0,gxz:"ZV19ComboEnfID",gxold:"OV19ComboEnfID",gxvar:"AV19ComboEnfID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV19ComboEnfID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV19ComboEnfID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOENFID",gx.O.AV19ComboEnfID,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV19ComboEnfID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOENFID",".")},nac:gx.falseFn};n[69]={id:69,fld:"SECTIONATTRIBUTE_CNTDID",grid:0};n[70]={id:70,lvl:0,type:"int",len:10,dec:0,sign:!1,pic:"ZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Combocntdid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOCNTDID",fmt:0,gxz:"ZV21ComboCntdID",gxold:"OV21ComboCntdID",gxvar:"AV21ComboCntdID",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV21ComboCntdID=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV21ComboCntdID=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOCNTDID",gx.O.AV21ComboCntdID,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV21ComboCntdID=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOCNTDID",".")},nac:gx.falseFn};this.A25ProtID=0;this.Z25ProtID=0;this.O25ProtID=0;this.A1EnfID=0;this.Z1EnfID=0;this.O1EnfID=0;this.A23CntdID=0;this.Z23CntdID=0;this.O23CntdID=0;this.A26ProtOrd=0;this.Z26ProtOrd=0;this.O26ProtOrd=0;this.A27ProtTxt="";this.Z27ProtTxt="";this.O27ProtTxt="";this.AV19ComboEnfID=0;this.ZV19ComboEnfID=0;this.OV19ComboEnfID=0;this.AV21ComboCntdID=0;this.ZV21ComboCntdID=0;this.OV21ComboCntdID=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV21ComboCntdID=0;this.AV19ComboEnfID=0;this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV25GXV1=0;this.AV11Insert_EnfID=0;this.AV18Combo_DataJson="";this.AV12Insert_CntdID=0;this.AV13TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV17ComboSelectedText="";this.AV16ComboSelectedValue="";this.AV7ProtID=0;this.AV10WebSession={};this.A25ProtID=0;this.A1EnfID=0;this.A23CntdID=0;this.AV24Pgmname="";this.A3EnfDesc="";this.A24CntdDesc="";this.A26ProtOrd=0;this.A27ProtTxt="";this.AV15DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV14EnfID_Data=[];this.AV20CntdID_Data=[];this.Gx_mode="";this.AV22DetailWCInfo={Link:"",Title:"",Keys:""};this.AV23CurrentTab_ReturnUrl="";this.Events={e13052_client:["AFTER TRN",!0],e16055_client:["ENTER",!0],e17055_client:["CANCEL",!0],e11055_client:["'CANCEL'",!1],e14055_client:["COMBO_CNTDID.ONOPTIONCLICKED",!1],e15055_client:["COMBO_ENFID.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7ProtID",fld:"vPROTID",pic:"ZZZZZZZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV22DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0},{av:"AV7ProtID",fld:"vPROTID",pic:"ZZZZZZZZZ9",hsh:!0},{av:"A25ProtID",fld:"PROTID",pic:"ZZZZZZZZZ9"}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"A25ProtID",fld:"PROTID",pic:"ZZZZZZZZZ9"},{av:"AV22DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0},{av:"A26ProtOrd",fld:"PROTORD",pic:"ZZZ9"},{av:"this.WWPUTILITIESContainer.CurrentTab_ReturnUrl",ctrl:"WWPUTILITIES",prop:"CurrentTab_ReturnUrl"}],[{av:"AV22DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0}]];this.EvtParms["'CANCEL'"]=[[{av:"this.WWPUTILITIESContainer.CurrentTab_ReturnUrl",ctrl:"WWPUTILITIES",prop:"CurrentTab_ReturnUrl"},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV22DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0}],[]];this.EvtParms["COMBO_CNTDID.ONOPTIONCLICKED"]=[[{av:"this.COMBO_CNTDIDContainer.SelectedValue_get",ctrl:"COMBO_CNTDID",prop:"SelectedValue_get"}],[{av:"AV21ComboCntdID",fld:"vCOMBOCNTDID",pic:"ZZZZZZZZZ9"}]];this.EvtParms["COMBO_ENFID.ONOPTIONCLICKED"]=[[{av:"this.COMBO_ENFIDContainer.SelectedValue_get",ctrl:"COMBO_ENFID",prop:"SelectedValue_get"}],[{av:"AV19ComboEnfID",fld:"vCOMBOENFID",pic:"ZZZZZZZZZ9"}]];this.EvtParms.VALID_PROTID=[[],[]];this.EvtParms.VALID_ENFID=[[{av:"A1EnfID",fld:"ENFID",pic:"ZZZZZZZZZ9"},{av:"A3EnfDesc",fld:"ENFDESC",pic:""}],[{av:"A3EnfDesc",fld:"ENFDESC",pic:""}]];this.EvtParms.VALID_CNTDID=[[{av:"A23CntdID",fld:"CNTDID",pic:"ZZZZZZZZZ9"},{av:"A24CntdDesc",fld:"CNTDDESC",pic:""}],[{av:"A24CntdDesc",fld:"CNTDDESC",pic:""}]];this.EvtParms.VALIDV_COMBOENFID=[[],[]];this.EvtParms.VALIDV_COMBOCNTDID=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7ProtID","vPROTID",0,"int",10,0);this.setVCMap("AV11Insert_EnfID","vINSERT_ENFID",0,"int",10,0);this.setVCMap("AV12Insert_CntdID","vINSERT_CNTDID",0,"int",10,0);this.setVCMap("A3EnfDesc","ENFDESC",0,"svchar",1024,0);this.setVCMap("A24CntdDesc","CNTDDESC",0,"char",60,0);this.setVCMap("AV24Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV22DetailWCInfo","vDETAILWCINFO",0,"WWPBaseObjectsSplitScreenDetailInfo",0,0);this.setVCMap("AV22DetailWCInfo","vDETAILWCINFO",0,"WWPBaseObjectsSplitScreenDetailInfo",0,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV23CurrentTab_ReturnUrl","vCURRENTTAB_RETURNURL",0,"svchar",200,0);this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}})});gx.wi(function(){gx.createParentObj(this.protocolo)})