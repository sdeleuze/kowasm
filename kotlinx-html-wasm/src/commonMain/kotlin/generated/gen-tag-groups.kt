package kotlinx.html

import kotlinx.html.*
import kotlinx.html.impl.*
import kotlinx.html.attributes.*

/*******************************************************************************
    DO NOT EDIT
    This file was generated by module generate
*******************************************************************************/

interface FlowContent : FlowOrMetaDataOrPhrasingContent, FlowOrHeadingContent, FlowOrMetaDataContent, FlowOrInteractiveContent, FlowOrPhrasingContent, SectioningOrFlowContent, FlowOrInteractiveOrPhrasingContent, Tag {
}

interface HeadingContent : FlowOrHeadingContent, Tag {
}

interface InteractiveContent : FlowOrInteractiveContent, FlowOrInteractiveOrPhrasingContent, Tag {
}

interface MetaDataContent : FlowOrMetaDataOrPhrasingContent, FlowOrMetaDataContent, Tag {
}

interface PhrasingContent : FlowOrMetaDataOrPhrasingContent, FlowOrPhrasingContent, FlowOrInteractiveOrPhrasingContent, Tag {
}

interface SectioningContent : SectioningOrFlowContent, Tag {
}

/**
 * Information on author
 */
@HtmlTagMarker
inline fun FlowContent.address(classes : String? = null, crossinline block : ADDRESS.() -> Unit = {}) : Unit = ADDRESS(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Long quotation
 */
@HtmlTagMarker
inline fun FlowContent.blockQuote(classes : String? = null, crossinline block : BLOCKQUOTE.() -> Unit = {}) : Unit = BLOCKQUOTE(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Dialog box or window
 */
@HtmlTagMarker
inline fun FlowContent.dialog(classes : String? = null, crossinline block : DIALOG.() -> Unit = {}) : Unit = DIALOG(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Generic language/style container
 */
@HtmlTagMarker
inline fun FlowContent.div(classes : String? = null, crossinline block : DIV.() -> Unit = {}) : Unit = DIV(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Definition list
 */
@HtmlTagMarker
inline fun FlowContent.dl(classes : String? = null, crossinline block : DL.() -> Unit = {}) : Unit = DL(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Form control group
 */
@HtmlTagMarker
inline fun FlowContent.fieldSet(classes : String? = null, crossinline block : FIELDSET.() -> Unit = {}) : Unit = FIELDSET(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Figure with optional caption
 */
@HtmlTagMarker
inline fun FlowContent.figure(classes : String? = null, crossinline block : FIGURE.() -> Unit = {}) : Unit = FIGURE(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Caption for 
 */
@HtmlTagMarker
inline fun FlowContent.figcaption(classes : String? = null, crossinline block : FIGCAPTION.() -> Unit = {}) : Unit = FIGCAPTION(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Footer for a page or section
 */
@HtmlTagMarker
inline fun FlowContent.footer(classes : String? = null, crossinline block : FOOTER.() -> Unit = {}) : Unit = FOOTER(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Interactive form
 */
@HtmlTagMarker
inline fun FlowContent.form(action : String? = null, encType : FormEncType? = null, method : FormMethod? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", method?.enumEncode(),"class", classes), consumer).visit(block)
@HtmlTagMarker
inline fun FlowContent.getForm(action : String? = null, encType : FormEncType? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", FormMethod.get.realValue,"class", classes), consumer).visit(block)
@HtmlTagMarker
inline fun FlowContent.postForm(action : String? = null, encType : FormEncType? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", FormMethod.post.realValue,"class", classes), consumer).visit(block)
@Suppress("DEPRECATION")
@HtmlTagMarker
inline fun FlowContent.putForm(action : String? = null, encType : FormEncType? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", FormMethod.put.realValue,"class", classes), consumer).visit(block)
@Suppress("DEPRECATION")
@HtmlTagMarker
inline fun FlowContent.deleteForm(action : String? = null, encType : FormEncType? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", FormMethod.delete.realValue,"class", classes), consumer).visit(block)
@Suppress("DEPRECATION")
@HtmlTagMarker
inline fun FlowContent.patchForm(action : String? = null, encType : FormEncType? = null, classes : String? = null, crossinline block : FORM.() -> Unit = {}) : Unit = FORM(attributesMapOf("action", action,"enctype", encType?.enumEncode(),"method", FormMethod.patch.realValue,"class", classes), consumer).visit(block)

/**
 * Introductory or navigational aids for a page or section
 */
@HtmlTagMarker
inline fun FlowContent.header(classes : String? = null, crossinline block : HEADER.() -> Unit = {}) : Unit = HEADER(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Horizontal rule
 */
@HtmlTagMarker
inline fun FlowContent.hr(classes : String? = null, crossinline block : HR.() -> Unit = {}) : Unit = HR(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Ordered list
 */
@HtmlTagMarker
inline fun FlowContent.ol(classes : String? = null, crossinline block : OL.() -> Unit = {}) : Unit = OL(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Paragraph
 */
@HtmlTagMarker
inline fun FlowContent.p(classes : String? = null, crossinline block : P.() -> Unit = {}) : Unit = P(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Preformatted text
 */
@HtmlTagMarker
inline fun FlowContent.pre(classes : String? = null, crossinline block : PRE.() -> Unit = {}) : Unit = PRE(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Caption for 
 */
@HtmlTagMarker
inline fun FlowContent.summary(classes : String? = null, crossinline block : SUMMARY.() -> Unit = {}) : Unit = SUMMARY(attributesMapOf("class", classes), consumer).visit(block)

/**
 * 
 */
@HtmlTagMarker
inline fun FlowContent.table(classes : String? = null, crossinline block : TABLE.() -> Unit = {}) : Unit = TABLE(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Unordered list
 */
@HtmlTagMarker
inline fun FlowContent.ul(classes : String? = null, crossinline block : UL.() -> Unit = {}) : Unit = UL(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Document base URI
 */
@HtmlTagMarker
inline fun MetaDataContent.base(classes : String? = null, crossinline block : BASE.() -> Unit = {}) : Unit = BASE(attributesMapOf("class", classes), consumer).visit(block)

/**
 * Document title
 */
@HtmlTagMarker
inline fun MetaDataContent.title(crossinline block : TITLE.() -> Unit = {}) : Unit = TITLE(emptyMap, consumer).visit(block)
/**
 * Document title
 */
@HtmlTagMarker
fun MetaDataContent.title(content : String = "") : Unit = TITLE(emptyMap, consumer).visit({+content})

