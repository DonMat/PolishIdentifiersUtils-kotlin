/*
 * Copyright (C) 2017 Mateusz Utkała
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.utkala.polishidentifiersutils

import org.junit.Assert.assertEquals
import org.junit.Test


class NipUtilTest {
    @Test
    fun validNipTest() {
        var nip = NipUtil("3790494818")
        assertEquals(nip.isValid(), true)
        assertEquals(nip.error, null)

        nip = NipUtil("PL 106-00-00-062")
        assertEquals(nip.isValid(), true)
        assertEquals(nip.error, null)
    }

    @Test
    fun invalidNipTest() {
        val nip = NipUtil("3790494811")
        assertEquals(nip.isValid(), false)
        assertEquals(nip.error, ValidatorError.INVALID)
    }

    @Test
    fun emptyNipTest() {
        val nip = NipUtil("")
        assertEquals(nip.isValid(), false)
        assertEquals(nip.error, ValidatorError.WRONG_LENGTH)
    }

    @Test
    fun shortNipTest() {
        val nip = NipUtil("1234")
        assertEquals(nip.isValid(), false)
        assertEquals(nip.error, ValidatorError.WRONG_LENGTH)
    }

    @Test
    fun longNipTest() {
        val nip = NipUtil("123412341234")
        assertEquals(nip.isValid(), false)
        assertEquals(nip.error, ValidatorError.WRONG_LENGTH)
    }

    @Test
    fun invalidInputTest() {
        val nip = NipUtil("EN 106-00-00-062")
        assertEquals(nip.isValid(), false)
        assertEquals(nip.error, ValidatorError.WRONG_LENGTH)
    }
}