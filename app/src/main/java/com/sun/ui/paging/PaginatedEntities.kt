package com.sun.ui.paging

data class PaginatedEntities<Post>(
    /** List of entities included in the current page */
    val data: MutableList<Post>?,
    /** The ID of the entity at the end of the current page. Null if there is no next */
    val nextPageNumber: Int?,
)
