package com.hiccs.arish;

import com.hiccs.arish.utils.DataUtils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by AbdullahAtta on 4/5/2019.
 */
public class GalleryTest {
    private static final int IMAGES_COUNT = 4;
    private static final String LAST_IMAGE_URL = "https://goo.gl/FN5aaD";

    @Test
    public void galleryImages_areEqualCount() {
        assertThat(DataUtils.getGalleryImages().size(), is(IMAGES_COUNT));
    }

    @Test
    public void lastImage_isMatched() {
        assertEquals(LAST_IMAGE_URL, DataUtils.getGalleryImages().get(IMAGES_COUNT - 1).getImageUrl());
    }
}
