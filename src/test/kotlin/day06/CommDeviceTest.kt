package day06

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CommDeviceTest {
    @Test
    fun findStartOfPacketMarker() {
        val device = CommDevice()
        assertEquals(5, device.findStartOfPacketMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, device.findStartOfPacketMarker("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, device.findStartOfPacketMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, device.findStartOfPacketMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun findStartOfMessageMarker() {
        val device = CommDevice()
        assertEquals(19, device.findStartOfMessageMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, device.findStartOfMessageMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, device.findStartOfMessageMarker("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, device.findStartOfMessageMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, device.findStartOfMessageMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}
