gx.evt.autoSkip=!1;gx.define("wwpbaseobjects.wwp_search",!1,function(){var t,n,r,u,i,f;this.ServerClass="wwpbaseobjects.wwp_search";this.PackageName="com";this.ServerFullClass="com.wwpbaseobjects.wwp_search";this.setObjectType("web");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV28WWP_SearchResults=gx.fn.getControlValue("vWWP_SEARCHRESULTS");this.AV23IsAdvancedSearch=gx.fn.getControlValue("vISADVANCEDSEARCH");this.AV5AdvFilterEntities=gx.fn.getControlValue("vADVFILTERENTITIES");this.AV10DeafultSearchText=gx.fn.getControlValue("vDEAFULTSEARCHTEXT");this.AV12DefaultIsAdvancedSearch=gx.fn.getControlValue("vDEFAULTISADVANCEDSEARCH");this.AV11DefaultAdvFilterEntitiesJson=gx.fn.getControlValue("vDEFAULTADVFILTERENTITIESJSON")};this.e170o1_client=function(){return this.clearMessages(),this.AV25SearchText=this.AV8AdvFilterText,this.AV23IsAdvancedSearch=!1,gx.fn.setCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible",this.AV23IsAdvancedSearch),gx.fn.setCtrlProperty("TABLESIMPLESEARCHCELL","Visible",!this.AV23IsAdvancedSearch),this.refreshOutputs([{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e180o1_client=function(){return this.clearMessages(),this.AV8AdvFilterText=this.AV25SearchText,this.AV23IsAdvancedSearch=!0,gx.fn.setCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible",this.AV23IsAdvancedSearch),gx.fn.setCtrlProperty("TABLESIMPLESEARCHCELL","Visible",!this.AV23IsAdvancedSearch),this.refreshOutputs([{av:"AV8AdvFilterText",fld:"vADVFILTERTEXT",pic:""},{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e190o1_client=function(){return this.clearMessages(),gx.json.SDTFromJson(this.AV5AdvFilterEntities,"undefined",this.COMBO_ADVFILTERENTITIESContainer.SelectedValue_get),this.refreshOutputs([{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e110o2_client=function(){return this.executeServerEvent("'DOBTNADVSEARCH'",!1,null,!1,!1)};this.e120o2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e130o2_client=function(){return this.executeServerEvent("TABLEFSCARD.CLICK",!0,arguments[0],!1,!0)};this.e200o2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44,46,47,49,50,51,52,53,54,55,57,58,59,62,63,64,65,66,67,68,69,70,71,72,73,74,75,78,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,107,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123];this.GXLastCtrlId=123;this.FsresultsContainer=new gx.grid.grid(this,3,"WbpLvl3",56,"Fsresults","Fsresults","FsresultsContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.wwp_search",[],!0,4,!1,!0,0,!1,!1,!1,"",0,"px",0,"px","Nueva fila",!1,!1,!1,null,null,!1,"",!0,[1,2,3,4],!1,0,!1,!1);n=this.FsresultsContainer;n.startDiv(57,"Unnamedtablefsfsresults","0px","0px");n.startDiv(58,"","0px","0px");n.startTable("Unnamedtablecontentfsfsresults",59,"0px");n.startRow("","","","","","");n.startCell("","","","","","","","","","");n.startDiv(62,"","0px","0px");n.addLabel();n.addSingleLineEdit("Url",63,"vURL","","","Url","svchar",40,"chr",40,40,"start",null,[],"Url","Url",!0,0,!1,!1,"Attribute",0,"");n.endDiv();n.endCell();n.endRow();n.endTable();n.endDiv();n.startDiv(64,"","0px","0px");n.startDiv(65,"Tablefscard","0px","0px");n.startDiv(66,"","0px","0px");n.startDiv(67,"Displaytype1_cell","0px","0px");n.startDiv(68,"Unnamedtable1","0px","0px");n.startDiv(69,"","0px","0px");n.startDiv(70,"","0px","0px");n.startDiv(71,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype1_title",72,"vDISPLAYTYPE1_TITLE","","","DisplayType1_Title","svchar",40,"chr",40,40,"start",null,[],"Displaytype1_title","DisplayType1_Title",!0,0,!1,!1,"AttributeSearchResultTitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.startDiv(73,"","0px","0px");n.startDiv(74,"Displaytype2_cell","0px","0px");n.startTable("Unnamedtable2",75,"0px");n.startRow("","","","","","");n.startCell("","","","","","","","","","");n.addTextBlock("DISPLAYTYPE2_ICON",null,78);n.endCell();n.startCell("","","","","","","","","","");n.startDiv(80,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype2_title",81,"vDISPLAYTYPE2_TITLE","","","DisplayType2_Title","svchar",40,"chr",40,40,"start",null,[],"Displaytype2_title","DisplayType2_Title",!0,0,!1,!1,"AttributeSearchResultTitle",0,"");n.endDiv();n.endCell();n.endRow();n.endTable();n.endDiv();n.endDiv();n.startDiv(82,"","0px","0px");n.startDiv(83,"Displaytype3_cell","0px","0px");n.startDiv(84,"Unnamedtable3","0px","0px");n.startDiv(85,"","0px","0px");n.startDiv(86,"","0px","0px");n.startDiv(87,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype3_title",88,"vDISPLAYTYPE3_TITLE","","","DisplayType3_Title","svchar",40,"chr",40,40,"start",null,[],"Displaytype3_title","DisplayType3_Title",!0,0,!1,!1,"AttributeSearchResultTitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.startDiv(89,"","0px","0px");n.startDiv(90,"","0px","0px");n.startDiv(91,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype3_subtitle",92,"vDISPLAYTYPE3_SUBTITLE","","","DisplayType3_Subtitle","svchar",40,"chr",40,40,"start",null,[],"Displaytype3_subtitle","DisplayType3_Subtitle",!0,0,!1,!1,"AttributeSearchResultSubtitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.startDiv(93,"","0px","0px");n.startDiv(94,"Displaytype4_cell","0px","0px");n.startDiv(95,"Unnamedtable4","0px","0px");n.startDiv(96,"","0px","0px");n.startDiv(97,"","0px","0px");n.addLabel();n.addBitmap("&Displaytype4_image","vDISPLAYTYPE4_IMAGE",98,0,"",0,"",null,"","","AttributeSearchResultImage","");n.endDiv();n.endDiv();n.startDiv(99,"","0px","0px");n.startDiv(100,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype4_title",101,"vDISPLAYTYPE4_TITLE","","","DisplayType4_Title","svchar",40,"chr",40,40,"start",null,[],"Displaytype4_title","DisplayType4_Title",!0,0,!1,!1,"AttributeSearchResultTitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.startDiv(102,"","0px","0px");n.startDiv(103,"Displaytype5_cell","0px","0px");n.startTable("Unnamedtable5",104,"0px");n.startRow("","","","","","");n.startCell("","","","","","","","","","");n.addTextBlock("DISPLAYTYPE5_ICON",null,107);n.endCell();n.startCell("","","","","","","","","","");n.startDiv(109,"Unnamedtable6","0px","0px");n.startDiv(110,"","0px","0px");n.startDiv(111,"","0px","0px");n.startDiv(112,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype5_title",113,"vDISPLAYTYPE5_TITLE","","","DisplayType5_Title","svchar",40,"chr",40,40,"start",null,[],"Displaytype5_title","DisplayType5_Title",!0,0,!1,!1,"AttributeSearchResultTitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.startDiv(114,"","0px","0px");n.startDiv(115,"","0px","0px");n.startDiv(116,"","0px","0px");n.addLabel();n.addSingleLineEdit("Displaytype5_subtitle",117,"vDISPLAYTYPE5_SUBTITLE","","","DisplayType5_Subtitle","svchar",40,"chr",40,40,"start",null,[],"Displaytype5_subtitle","DisplayType5_Subtitle",!0,0,!1,!1,"AttributeSearchResultSubtitle",0,"");n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endCell();n.endRow();n.endTable();n.endDiv();n.endDiv();n.endDiv();n.endDiv();n.endDiv();this.FsresultsContainer.emptyText="";this.FsresultcategoriesContainer=new gx.grid.grid(this,2,"WbpLvl2",48,"Fsresultcategories","Fsresultcategories","FsresultcategoriesContainer",this.CmpContext,this.IsMasterPage,"wwpbaseobjects.wwp_search",[],!0,1,!1,!0,0,!1,!1,!1,"CollWWPBaseObjectsWWP_SearchResults.WWP_SearchResultsItem",0,"px",0,"px","Nueva fila",!1,!1,!1,null,null,!1,"AV28WWP_SearchResults",!0,[1,1,1,1],!1,0,!1,!1);r=this.FsresultcategoriesContainer;r.startDiv(49,"Unnamedtablefsfsresultcategories","0px","0px");r.startDiv(50,"","0px","0px");r.startDiv(51,"","0px","0px");r.startDiv(52,"","0px","0px");r.addLabel();r.addSingleLineEdit("GXV2",53,"WWP_SEARCHRESULTS__CATEGORYNAME","","","CategoryName","svchar",40,"chr",40,40,"start",null,[],"GXV2","GXV2",!0,0,!1,!1,"Attribute",0,"");r.endDiv();r.endDiv();r.endDiv();r.startDiv(54,"","0px","0px");r.startDiv(55,"","0px","0px");r.addGrid(this.FsresultsContainer);r.endDiv();r.endDiv();r.startDiv(118,"","0px","0px");r.startDiv(119,"","0px","0px");r.addTextBlock("TXTSHOWINGONLY",null,120);r.endDiv();r.endDiv();r.endDiv();this.FsresultcategoriesContainer.emptyText="";this.setGrid(r);this.BTNADVANCEDSEARCHContainer=gx.uc.getNew(this,23,19,"WWP_IconButton","BTNADVANCEDSEARCHContainer","Btnadvancedsearch","BTNADVANCEDSEARCH");u=this.BTNADVANCEDSEARCHContainer;u.setProp("Enabled","Enabled",!0,"boolean");u.setProp("TooltipText","Tooltiptext","","str");u.setProp("BeforeIconClass","Beforeiconclass","fas fa-filter","str");u.setProp("AfterIconClass","Aftericonclass","","str");u.addEventHandler("Event",this.e180o1_client);u.setProp("Caption","Caption","Búsqueda avanzada","str");u.setProp("Class","Class","IconButtonLink","str");u.setProp("Visible","Visible",!0,"bool");u.setC2ShowFunction(function(n){n.show()});this.setUserControl(u);this.COMBO_ADVFILTERENTITIESContainer=gx.uc.getNew(this,41,19,"BootstrapDropDownOptions","COMBO_ADVFILTERENTITIESContainer","Combo_advfilterentities","COMBO_ADVFILTERENTITIES");i=this.COMBO_ADVFILTERENTITIESContainer;i.setProp("Class","Class","","char");i.setProp("IconType","Icontype","Image","str");i.setProp("Icon","Icon","","str");i.setProp("Caption","Caption","","str");i.setProp("Tooltip","Tooltip","","str");i.setProp("Cls","Cls","ExtendedCombo Attribute","str");i.setDynProp("SelectedValue_set","Selectedvalue_set","","char");i.setProp("SelectedValue_get","Selectedvalue_get","","char");i.setProp("SelectedText_set","Selectedtext_set","","char");i.setProp("SelectedText_get","Selectedtext_get","","char");i.setProp("GAMOAuthToken","Gamoauthtoken","","char");i.setProp("DDOInternalName","Ddointernalname","","char");i.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");i.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");i.setProp("Enabled","Enabled",!0,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");i.setProp("DataListType","Datalisttype","Dynamic","str");i.setProp("AllowMultipleSelection","Allowmultipleselection",!0,"bool");i.setProp("DataListFixedValues","Datalistfixedvalues","","char");i.setProp("IsGridItem","Isgriditem",!1,"bool");i.setProp("HasDescription","Hasdescription",!1,"bool");i.setProp("DataListProc","Datalistproc","","str");i.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");i.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");i.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");i.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!0,"bool");i.setProp("IncludeSelectAllOption","Includeselectalloption",!0,"bool");i.setProp("EmptyItem","Emptyitem",!1,"bool");i.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");i.setProp("HTMLTemplate","Htmltemplate","","str");i.setProp("MultipleValuesType","Multiplevaluestype","Tags","str");i.setProp("LoadingData","Loadingdata","","char");i.setProp("NoResultsFound","Noresultsfound","","char");i.setProp("EmptyItemText","Emptyitemtext","","char");i.setProp("OnlySelectedValues","Onlyselectedvalues","","str");i.setProp("SelectAllText","Selectalltext","","str");i.setProp("MultipleValuesSeparator","Multiplevaluesseparator",", ","str");i.setProp("AddNewOptionText","Addnewoptiontext","","str");i.addV2CFunction("AV9DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");i.addC2VFunction(function(n){n.ParentObject.AV9DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV9DDO_TitleSettingsIcons)});i.addV2CFunction("AV6AdvFilterEntities_Data","vADVFILTERENTITIES_DATA","SetDropDownOptionsData");i.addC2VFunction(function(n){n.ParentObject.AV6AdvFilterEntities_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vADVFILTERENTITIES_DATA",n.ParentObject.AV6AdvFilterEntities_Data)});i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("OnOptionClicked",this.e190o1_client);this.setUserControl(i);this.BTNBASICSEARCHContainer=gx.uc.getNew(this,45,19,"WWP_IconButton","BTNBASICSEARCHContainer","Btnbasicsearch","BTNBASICSEARCH");f=this.BTNBASICSEARCHContainer;f.setProp("Enabled","Enabled",!0,"boolean");f.setProp("TooltipText","Tooltiptext","","str");f.setProp("BeforeIconClass","Beforeiconclass","fas fa-filter","str");f.setProp("AfterIconClass","Aftericonclass","","str");f.addEventHandler("Event",this.e170o1_client);f.setProp("Caption","Caption","Búsqueda básica","str");f.setProp("Class","Class","IconButtonLink","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLEHEADER",grid:0};t[10]={id:10,fld:"TABLESIMPLESEARCHCELL",grid:0};t[11]={id:11,fld:"UNNAMEDTABLE7",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"UNNAMEDTABLE9",grid:0};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSEARCHTEXT",fmt:0,gxz:"ZV25SearchText",gxold:"OV25SearchText",gxvar:"AV25SearchText",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV25SearchText=n)},v2z:function(n){n!==undefined&&(gx.O.ZV25SearchText=n)},v2c:function(){gx.fn.setControlValue("vSEARCHTEXT",gx.O.AV25SearchText,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV25SearchText=this.val())},val:function(){return gx.fn.getControlValue("vSEARCHTEXT")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"BTNENTER",grid:0,evt:"e120o2_client",std:"ENTER"};t[22]={id:22,fld:"",grid:0};t[24]={id:24,fld:"TABLEADVANCEDSEARCHCELL",grid:0};t[25]={id:25,fld:"TABLEADVANCEDSEARCH",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"UNNAMEDTABLE8",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vADVFILTERTEXT",fmt:0,gxz:"ZV8AdvFilterText",gxold:"OV8AdvFilterText",gxvar:"AV8AdvFilterText",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV8AdvFilterText=n)},v2z:function(n){n!==undefined&&(gx.O.ZV8AdvFilterText=n)},v2c:function(){gx.fn.setControlValue("vADVFILTERTEXT",gx.O.AV8AdvFilterText,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV8AdvFilterText=this.val())},val:function(){return gx.fn.getControlValue("vADVFILTERTEXT")},nac:gx.falseFn};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"TABLESPLITTEDADVFILTERENTITIES",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"TEXTBLOCKCOMBO_ADVFILTERENTITIES",format:0,grid:0,ctrltype:"textblock"};t[40]={id:40,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"BTNBTNADVSEARCH",grid:0,evt:"e110o2_client"};t[44]={id:44,fld:"",grid:0};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"FSRESULTCATEGORIESCELL",grid:0};t[49]={id:49,fld:"UNNAMEDTABLEFSFSRESULTCATEGORIES",grid:48};t[50]={id:50,fld:"",grid:48};t[51]={id:51,fld:"",grid:48};t[52]={id:52,fld:"",grid:48};t[53]={id:53,lvl:2,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:48,gxgrid:this.FsresultcategoriesContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"WWP_SEARCHRESULTS__CATEGORYNAME",fmt:0,gxz:"ZV31GXV2",gxold:"OV31GXV2",gxvar:"GXV2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.GXV2=n)},v2z:function(n){n!==undefined&&(gx.O.ZV31GXV2=n)},v2c:function(n){gx.fn.setGridControlValue("WWP_SEARCHRESULTS__CATEGORYNAME",n||gx.fn.currentGridRowImpl(48),gx.O.GXV2,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV2=this.val(n))},val:function(n){return gx.fn.getGridControlValue("WWP_SEARCHRESULTS__CATEGORYNAME",n||gx.fn.currentGridRowImpl(48))},nac:gx.falseFn};t[54]={id:54,fld:"",grid:48};t[55]={id:55,fld:"",grid:48};t[57]={id:57,fld:"UNNAMEDTABLEFSFSRESULTS",grid:56};t[58]={id:58,fld:"",grid:56};t[59]={id:59,fld:"UNNAMEDTABLECONTENTFSFSRESULTS",grid:56};t[62]={id:62,fld:"",grid:56};t[63]={id:63,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vURL",fmt:0,gxz:"ZV26Url",gxold:"OV26Url",gxvar:"AV26Url",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV26Url=n)},v2z:function(n){n!==undefined&&(gx.O.ZV26Url=n)},v2c:function(n){gx.fn.setGridControlValue("vURL",n||gx.fn.currentGridRowImpl(56),gx.O.AV26Url,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV26Url=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vURL",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[64]={id:64,fld:"",grid:56};t[65]={id:65,fld:"TABLEFSCARD",grid:56,evt:"e130o2_client"};t[66]={id:66,fld:"",grid:56};t[67]={id:67,fld:"DISPLAYTYPE1_CELL",grid:56};t[68]={id:68,fld:"UNNAMEDTABLE1",grid:56};t[69]={id:69,fld:"",grid:56};t[70]={id:70,fld:"",grid:56};t[71]={id:71,fld:"",grid:56};t[72]={id:72,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE1_TITLE",fmt:0,gxz:"ZV13DisplayType1_Title",gxold:"OV13DisplayType1_Title",gxvar:"AV13DisplayType1_Title",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV13DisplayType1_Title=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13DisplayType1_Title=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE1_TITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV13DisplayType1_Title,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV13DisplayType1_Title=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE1_TITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[73]={id:73,fld:"",grid:56};t[74]={id:74,fld:"DISPLAYTYPE2_CELL",grid:56};t[75]={id:75,fld:"UNNAMEDTABLE2",grid:56};t[78]={id:78,fld:"DISPLAYTYPE2_ICON",format:2,grid:56,ctrltype:"textblock"};t[80]={id:80,fld:"",grid:56};t[81]={id:81,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE2_TITLE",fmt:0,gxz:"ZV14DisplayType2_Title",gxold:"OV14DisplayType2_Title",gxvar:"AV14DisplayType2_Title",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV14DisplayType2_Title=n)},v2z:function(n){n!==undefined&&(gx.O.ZV14DisplayType2_Title=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE2_TITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV14DisplayType2_Title,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV14DisplayType2_Title=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE2_TITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[82]={id:82,fld:"",grid:56};t[83]={id:83,fld:"DISPLAYTYPE3_CELL",grid:56};t[84]={id:84,fld:"UNNAMEDTABLE3",grid:56};t[85]={id:85,fld:"",grid:56};t[86]={id:86,fld:"",grid:56};t[87]={id:87,fld:"",grid:56};t[88]={id:88,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE3_TITLE",fmt:0,gxz:"ZV16DisplayType3_Title",gxold:"OV16DisplayType3_Title",gxvar:"AV16DisplayType3_Title",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV16DisplayType3_Title=n)},v2z:function(n){n!==undefined&&(gx.O.ZV16DisplayType3_Title=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE3_TITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV16DisplayType3_Title,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV16DisplayType3_Title=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE3_TITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[89]={id:89,fld:"",grid:56};t[90]={id:90,fld:"",grid:56};t[91]={id:91,fld:"",grid:56};t[92]={id:92,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE3_SUBTITLE",fmt:0,gxz:"ZV15DisplayType3_Subtitle",gxold:"OV15DisplayType3_Subtitle",gxvar:"AV15DisplayType3_Subtitle",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV15DisplayType3_Subtitle=n)},v2z:function(n){n!==undefined&&(gx.O.ZV15DisplayType3_Subtitle=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE3_SUBTITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV15DisplayType3_Subtitle,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV15DisplayType3_Subtitle=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE3_SUBTITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[93]={id:93,fld:"",grid:56};t[94]={id:94,fld:"DISPLAYTYPE4_CELL",grid:56};t[95]={id:95,fld:"UNNAMEDTABLE4",grid:56};t[96]={id:96,fld:"",grid:56};t[97]={id:97,fld:"",grid:56};t[98]={id:98,lvl:3,type:"bits",len:1024,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE4_IMAGE",fmt:0,gxz:"ZV17DisplayType4_Image",gxold:"OV17DisplayType4_Image",gxvar:"AV17DisplayType4_Image",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV17DisplayType4_Image=n)},v2z:function(n){n!==undefined&&(gx.O.ZV17DisplayType4_Image=n)},v2c:function(n){gx.fn.setGridMultimediaValue("vDISPLAYTYPE4_IMAGE",n||gx.fn.currentGridRowImpl(56),gx.O.AV17DisplayType4_Image,gx.O.AV33Displaytype4_image_GXI)},c2v:function(n){gx.O.AV33Displaytype4_image_GXI=this.val_GXI();this.val(n)!==undefined&&(gx.O.AV17DisplayType4_Image=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE4_IMAGE",n||gx.fn.currentGridRowImpl(56))},val_GXI:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE4_IMAGE_GXI",n||gx.fn.currentGridRowImpl(56))},gxvar_GXI:"AV33Displaytype4_image_GXI",nac:gx.falseFn};t[99]={id:99,fld:"",grid:56};t[100]={id:100,fld:"",grid:56};t[101]={id:101,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE4_TITLE",fmt:0,gxz:"ZV18DisplayType4_Title",gxold:"OV18DisplayType4_Title",gxvar:"AV18DisplayType4_Title",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV18DisplayType4_Title=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18DisplayType4_Title=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE4_TITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV18DisplayType4_Title,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV18DisplayType4_Title=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE4_TITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[102]={id:102,fld:"",grid:56};t[103]={id:103,fld:"DISPLAYTYPE5_CELL",grid:56};t[104]={id:104,fld:"UNNAMEDTABLE5",grid:56};t[107]={id:107,fld:"DISPLAYTYPE5_ICON",format:2,grid:56,ctrltype:"textblock"};t[109]={id:109,fld:"UNNAMEDTABLE6",grid:56};t[110]={id:110,fld:"",grid:56};t[111]={id:111,fld:"",grid:56};t[112]={id:112,fld:"",grid:56};t[113]={id:113,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE5_TITLE",fmt:0,gxz:"ZV20DisplayType5_Title",gxold:"OV20DisplayType5_Title",gxvar:"AV20DisplayType5_Title",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV20DisplayType5_Title=n)},v2z:function(n){n!==undefined&&(gx.O.ZV20DisplayType5_Title=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE5_TITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV20DisplayType5_Title,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV20DisplayType5_Title=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE5_TITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[114]={id:114,fld:"",grid:56};t[115]={id:115,fld:"",grid:56};t[116]={id:116,fld:"",grid:56};t[117]={id:117,lvl:3,type:"svchar",len:40,dec:0,sign:!1,ro:1,isacc:0,grid:56,gxgrid:this.FsresultsContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vDISPLAYTYPE5_SUBTITLE",fmt:0,gxz:"ZV19DisplayType5_Subtitle",gxold:"OV19DisplayType5_Subtitle",gxvar:"AV19DisplayType5_Subtitle",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV19DisplayType5_Subtitle=n)},v2z:function(n){n!==undefined&&(gx.O.ZV19DisplayType5_Subtitle=n)},v2c:function(n){gx.fn.setGridControlValue("vDISPLAYTYPE5_SUBTITLE",n||gx.fn.currentGridRowImpl(56),gx.O.AV19DisplayType5_Subtitle,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV19DisplayType5_Subtitle=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vDISPLAYTYPE5_SUBTITLE",n||gx.fn.currentGridRowImpl(56))},nac:gx.falseFn};t[118]={id:118,fld:"",grid:48};t[119]={id:119,fld:"",grid:48};t[120]={id:120,fld:"TXTSHOWINGONLY",format:0,grid:48,ctrltype:"textblock"};t[121]={id:121,fld:"",grid:0};t[122]={id:122,fld:"TXTNORESULTSCELL",grid:0};t[123]={id:123,fld:"TXTNORESULTS",format:0,grid:0,ctrltype:"textblock"};this.AV25SearchText="";this.ZV25SearchText="";this.OV25SearchText="";this.AV8AdvFilterText="";this.ZV8AdvFilterText="";this.OV8AdvFilterText="";this.ZV31GXV2="";this.OV31GXV2="";this.ZV26Url="";this.OV26Url="";this.ZV13DisplayType1_Title="";this.OV13DisplayType1_Title="";this.ZV14DisplayType2_Title="";this.OV14DisplayType2_Title="";this.ZV16DisplayType3_Title="";this.OV16DisplayType3_Title="";this.ZV15DisplayType3_Subtitle="";this.OV15DisplayType3_Subtitle="";this.ZV17DisplayType4_Image="";this.OV17DisplayType4_Image="";this.ZV18DisplayType4_Title="";this.OV18DisplayType4_Title="";this.ZV20DisplayType5_Title="";this.OV20DisplayType5_Title="";this.ZV19DisplayType5_Subtitle="";this.OV19DisplayType5_Subtitle="";this.AV25SearchText="";this.AV8AdvFilterText="";this.AV9DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV10DeafultSearchText="";this.AV12DefaultIsAdvancedSearch=!1;this.AV11DefaultAdvFilterEntitiesJson="";this.GXV2="";this.AV26Url="";this.AV13DisplayType1_Title="";this.AV14DisplayType2_Title="";this.AV16DisplayType3_Title="";this.AV15DisplayType3_Subtitle="";this.AV17DisplayType4_Image="";this.AV18DisplayType4_Title="";this.AV20DisplayType5_Title="";this.AV19DisplayType5_Subtitle="";this.AV28WWP_SearchResults=[];this.AV23IsAdvancedSearch=!1;this.AV5AdvFilterEntities=[];this.Events={e110o2_client:["'DOBTNADVSEARCH'",!0],e120o2_client:["ENTER",!0],e130o2_client:["TABLEFSCARD.CLICK",!0],e200o2_client:["CANCEL",!0],e170o1_client:["'DOBASICSEARCH'",!1],e180o1_client:["'DOADVANCEDSEARCH'",!1],e190o1_client:["COMBO_ADVFILTERENTITIES.ONOPTIONCLICKED",!1]};this.EvtParms.REFRESH=[[{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"FSRESULTCATEGORIES_nEOF"},{av:"FSRESULTS_nFirstRecordOnPage"},{av:"FSRESULTS_nEOF"},{av:'gx.fn.getCtrlProperty("vURL","Visible")',ctrl:"vURL",prop:"Visible"},{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:"AV10DeafultSearchText",fld:"vDEAFULTSEARCHTEXT",pic:"",hsh:!0},{av:"AV12DefaultIsAdvancedSearch",fld:"vDEFAULTISADVANCEDSEARCH",pic:"",hsh:!0},{av:"AV11DefaultAdvFilterEntitiesJson",fld:"vDEFAULTADVFILTERENTITIESJSON",pic:"",hsh:!0}],[]];this.EvtParms["FSRESULTCATEGORIES.LOAD"]=[[{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48}],[{av:'gx.fn.getCtrlProperty("TXTSHOWINGONLY","Caption")',ctrl:"TXTSHOWINGONLY",prop:"Caption"}]];this.EvtParms["FSRESULTS.LOAD"]=[[{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48}],[{av:'gx.fn.getCtrlProperty("DISPLAYTYPE1_CELL","Visible")',ctrl:"DISPLAYTYPE1_CELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE2_CELL","Visible")',ctrl:"DISPLAYTYPE2_CELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE3_CELL","Visible")',ctrl:"DISPLAYTYPE3_CELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE4_CELL","Visible")',ctrl:"DISPLAYTYPE4_CELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE5_CELL","Visible")',ctrl:"DISPLAYTYPE5_CELL",prop:"Visible"},{av:"AV13DisplayType1_Title",fld:"vDISPLAYTYPE1_TITLE",pic:""},{av:"AV14DisplayType2_Title",fld:"vDISPLAYTYPE2_TITLE",pic:""},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE2_ICON","Caption")',ctrl:"DISPLAYTYPE2_ICON",prop:"Caption"},{av:"AV16DisplayType3_Title",fld:"vDISPLAYTYPE3_TITLE",pic:""},{av:"AV15DisplayType3_Subtitle",fld:"vDISPLAYTYPE3_SUBTITLE",pic:""},{av:"AV18DisplayType4_Title",fld:"vDISPLAYTYPE4_TITLE",pic:""},{av:"AV17DisplayType4_Image",fld:"vDISPLAYTYPE4_IMAGE",pic:""},{av:'gx.fn.getCtrlProperty("vDISPLAYTYPE4_IMAGE","Visible")',ctrl:"vDISPLAYTYPE4_IMAGE",prop:"Visible"},{av:"AV20DisplayType5_Title",fld:"vDISPLAYTYPE5_TITLE",pic:""},{av:"AV19DisplayType5_Subtitle",fld:"vDISPLAYTYPE5_SUBTITLE",pic:""},{av:'gx.fn.getCtrlProperty("DISPLAYTYPE5_ICON","Caption")',ctrl:"DISPLAYTYPE5_ICON",prop:"Caption"},{av:"AV26Url",fld:"vURL",pic:""}]];this.EvtParms["'DOBASICSEARCH'"]=[[{av:"AV8AdvFilterText",fld:"vADVFILTERTEXT",pic:""}],[{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"}]];this.EvtParms["'DOBTNADVSEARCH'"]=[[{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:"AV8AdvFilterText",fld:"vADVFILTERTEXT",pic:""},{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""},{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:"FSRESULTCATEGORIES_nEOF"},{av:"FSRESULTS_nFirstRecordOnPage"},{av:"FSRESULTS_nEOF"},{av:'gx.fn.getCtrlProperty("vURL","Visible")',ctrl:"vURL",prop:"Visible"},{av:"AV10DeafultSearchText",fld:"vDEAFULTSEARCHTEXT",pic:"",hsh:!0},{av:"AV12DefaultIsAdvancedSearch",fld:"vDEFAULTISADVANCEDSEARCH",pic:"",hsh:!0},{av:"AV11DefaultAdvFilterEntitiesJson",fld:"vDEFAULTADVFILTERENTITIESJSON",pic:"",hsh:!0}],[{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"},{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""},{av:"this.COMBO_ADVFILTERENTITIESContainer.SelectedValue_set",ctrl:"COMBO_ADVFILTERENTITIES",prop:"SelectedValue_set"},{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:'gx.fn.getCtrlProperty("TXTNORESULTS","Caption")',ctrl:"TXTNORESULTS",prop:"Caption"},{av:'gx.fn.getCtrlProperty("FSRESULTCATEGORIESCELL","Visible")',ctrl:"FSRESULTCATEGORIESCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TXTNORESULTSCELL","Visible")',ctrl:"TXTNORESULTSCELL",prop:"Visible"}]];this.EvtParms["'DOADVANCEDSEARCH'"]=[[{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""}],[{av:"AV8AdvFilterText",fld:"vADVFILTERTEXT",pic:""},{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"}]];this.EvtParms.ENTER=[[{av:"AV23IsAdvancedSearch",fld:"vISADVANCEDSEARCH",pic:""},{av:"AV8AdvFilterText",fld:"vADVFILTERTEXT",pic:""},{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""},{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:"FSRESULTCATEGORIES_nEOF"},{av:"FSRESULTS_nFirstRecordOnPage"},{av:"FSRESULTS_nEOF"},{av:'gx.fn.getCtrlProperty("vURL","Visible")',ctrl:"vURL",prop:"Visible"},{av:"AV10DeafultSearchText",fld:"vDEAFULTSEARCHTEXT",pic:"",hsh:!0},{av:"AV12DefaultIsAdvancedSearch",fld:"vDEFAULTISADVANCEDSEARCH",pic:"",hsh:!0},{av:"AV11DefaultAdvFilterEntitiesJson",fld:"vDEFAULTADVFILTERENTITIESJSON",pic:"",hsh:!0}],[{av:'gx.fn.getCtrlProperty("TABLEADVANCEDSEARCHCELL","Visible")',ctrl:"TABLEADVANCEDSEARCHCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TABLESIMPLESEARCHCELL","Visible")',ctrl:"TABLESIMPLESEARCHCELL",prop:"Visible"},{av:"AV25SearchText",fld:"vSEARCHTEXT",pic:""},{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""},{av:"this.COMBO_ADVFILTERENTITIESContainer.SelectedValue_set",ctrl:"COMBO_ADVFILTERENTITIES",prop:"SelectedValue_set"},{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:'gx.fn.getCtrlProperty("TXTNORESULTS","Caption")',ctrl:"TXTNORESULTS",prop:"Caption"},{av:'gx.fn.getCtrlProperty("FSRESULTCATEGORIESCELL","Visible")',ctrl:"FSRESULTCATEGORIESCELL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("TXTNORESULTSCELL","Visible")',ctrl:"TXTNORESULTSCELL",prop:"Visible"}]];this.EvtParms["COMBO_ADVFILTERENTITIES.ONOPTIONCLICKED"]=[[{av:"this.COMBO_ADVFILTERENTITIESContainer.SelectedValue_get",ctrl:"COMBO_ADVFILTERENTITIES",prop:"SelectedValue_get"}],[{av:"AV5AdvFilterEntities",fld:"vADVFILTERENTITIES",pic:""}]];this.EvtParms["TABLEFSCARD.CLICK"]=[[{av:"AV28WWP_SearchResults",fld:"vWWP_SEARCHRESULTS",grid:48,pic:""},{av:"nGXsfl_48_idx",ctrl:"GRID",prop:"GridCurrRow",grid:48},{av:"FSRESULTCATEGORIES_nFirstRecordOnPage"},{av:"nRC_GXsfl_48",ctrl:"FSRESULTCATEGORIES",prop:"GridRC",grid:48},{av:"AV26Url",fld:"vURL",pic:""}],[]];this.EnterCtrl=["BTNENTER"];this.setVCMap("AV28WWP_SearchResults","vWWP_SEARCHRESULTS",0,"CollWWPBaseObjectsWWP_SearchResults.WWP_SearchResultsItem",0,0);this.setVCMap("AV23IsAdvancedSearch","vISADVANCEDSEARCH",0,"boolean",4,0);this.setVCMap("AV5AdvFilterEntities","vADVFILTERENTITIES",0,"Collsvchar",0,0);this.setVCMap("AV10DeafultSearchText","vDEAFULTSEARCHTEXT",0,"svchar",40,0);this.setVCMap("AV12DefaultIsAdvancedSearch","vDEFAULTISADVANCEDSEARCH",0,"boolean",4,0);this.setVCMap("AV11DefaultAdvFilterEntitiesJson","vDEFAULTADVFILTERENTITIESJSON",0,"svchar",40,0);this.setVCMap("AV28WWP_SearchResults","vWWP_SEARCHRESULTS",0,"CollWWPBaseObjectsWWP_SearchResults.WWP_SearchResultsItem",0,0);this.setVCMap("AV5AdvFilterEntities","vADVFILTERENTITIES",0,"Collsvchar",0,0);this.setVCMap("AV23IsAdvancedSearch","vISADVANCEDSEARCH",0,"boolean",4,0);this.setVCMap("AV28WWP_SearchResults","vWWP_SEARCHRESULTS",0,"CollWWPBaseObjectsWWP_SearchResults.WWP_SearchResultsItem",0,0);n.addRefreshingVar({rfrVar:"AV26Url",rfrProp:"Visible",gxAttId:"Url"});n.addRefreshingVar({rfrVar:"AV28WWP_SearchResults"});n.addRefreshingVar({rfrVar:"AV10DeafultSearchText"});n.addRefreshingVar({rfrVar:"AV12DefaultIsAdvancedSearch"});n.addRefreshingVar({rfrVar:"AV11DefaultAdvFilterEntitiesJson"});n.addRefreshingParm({rfrVar:"AV26Url",rfrProp:"Visible",gxAttId:"Url"});n.addRefreshingParm({rfrVar:"AV28WWP_SearchResults"});n.addRefreshingParm({rfrVar:"AV10DeafultSearchText"});n.addRefreshingParm({rfrVar:"AV12DefaultIsAdvancedSearch"});n.addRefreshingParm({rfrVar:"AV11DefaultAdvFilterEntitiesJson"});r.addRefreshingVar({rfrVar:"AV28WWP_SearchResults"});r.addRefreshingVar({rfrVar:"AV10DeafultSearchText"});r.addRefreshingVar({rfrVar:"AV12DefaultIsAdvancedSearch"});r.addRefreshingVar({rfrVar:"AV11DefaultAdvFilterEntitiesJson"});r.addRefreshingParm({rfrVar:"AV28WWP_SearchResults"});r.addRefreshingParm({rfrVar:"AV10DeafultSearchText"});r.addRefreshingParm({rfrVar:"AV12DefaultIsAdvancedSearch"});r.addRefreshingParm({rfrVar:"AV11DefaultAdvFilterEntitiesJson"});this.addGridBCProperty("Wwp_searchresults",["CategoryName"],this.GXValidFnc[53],"AV28WWP_SearchResults");this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWP_SearchResults.WWP_SearchResultsItem",{Result:{sdt:"WWPBaseObjects\\WWP_SearchResults.WWP_SearchResultsItem.ResultItem"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}})});gx.wi(function(){gx.createParentObj(this.wwpbaseobjects.wwp_search)})